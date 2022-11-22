/*
 *  © [2021] Cognizant. All rights reserved.
 *
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 */

package com.cognizant.collector.jira.component;

import com.cognizant.collector.jira.beans.Project;
import com.cognizant.collector.jira.beans.core.*;
import com.cognizant.collector.jira.client.*;
import com.cognizant.collector.jira.service.*;
import lombok.extern.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.util.*;

import java.util.*;
import java.util.stream.*;

import static com.cognizant.collector.jira.constants.Constant.*;
/**
 * ZephyrIssueComponent
 * @author Cognizant
 */

@Component
@Slf4j
public class JiraIssueComponent {

    @Autowired
    JiraIssueService service;
    @Autowired
    JiraClient client;
    @Autowired
    CommonUtilComponent utilComponent;

    public List<Project> getProjects() {
        return client.getJiraProjects();
    }

    public JiraIssueDetails getIssues(Map<String, String> requestParam) {
        return client.getJiraIssues(requestParam);
    }

    private List<JiraIssue> saveAllIssuesInDB(List<JiraIssue> issues) {
        return service.addAll(issues);
    }

    private void getIssuesAndStoreInDB(List<JiraIssueInfo> issueInfoList) {
        List<JiraIssue> issues = issueInfoList.stream().map(jiraIssueInfo -> {

            IssueType issueType = jiraIssueInfo.getFields().getIssuetype();
            List<String> customfield_10101 = jiraIssueInfo.getFields().getCustomfield_10101();

            if (issueType !=null && !CollectionUtils.isEmpty(customfield_10101)){
                String customField = customfield_10101.get(0);
                SprintDetails sprintDetails = utilComponent.getSprintDetailsFromString(customField);
                jiraIssueInfo.getFields().setSprintDetails(sprintDetails);
            }

            return jiraIssueInfo.getJiraIssue();
        }).collect(Collectors.toList());

        List<JiraIssue> jiraIssues = saveAllIssuesInDB(issues);
        log.info("JiraIssues stored in DB, Count: {}", jiraIssues.size());
    }

//    private void getAllIssuesByProject(Project project) {
//        Map<String, String> map = new HashMap<>();
//        int resultPerPage = RESULTS_PER_PAGE;
//        int startAt = PAGE_STARTS_AT;
//        boolean isCompleted = false;
//        Date maxUpdatedDate = service.getMaxUpdatedDate(project.getKey());
//        String jqlParamString = utilComponent.getJqlParamString(project.getKey(), maxUpdatedDate);
//        map.put(JQL, jqlParamString);
//        map.put(MAX_RESULTS, String.valueOf(resultPerPage));
//        do {
//
//            map.put(START_AT, String.valueOf(startAt));
//            log.info("StartAt:{}, MaxResult:{}, JqlString:{}", startAt, resultPerPage, jqlParamString);
//            JiraIssueDetails issues = getIssues(map);
//
//            List<JiraIssueInfo> issueInfoList = issues.getIssues();
//
//            System.out.println(issueInfoList);
//
//            if (CollectionUtils.isEmpty(issueInfoList)) {
//                isCompleted = true;
//            } else {
//                startAt += resultPerPage;
//                if (issues.getTotal() < startAt) isCompleted = true;
//                log.info("Issues count form server : {}", issueInfoList.size());
//                getIssuesAndStoreInDB(issueInfoList);
//            }
//        } while (!isCompleted);
//
//        getAllIssuesKeyByProject(project);
//    }

    private void getAllIssuesByProjectId(Project project) {

        getAllIssuesKeyByProjectId(project);

        Map<String, String> map = new HashMap<>();
        int resultPerPage = RESULTS_PER_PAGE;
        int startAt = PAGE_STARTS_AT;
        boolean isCompleted = false;
        Date maxUpdatedDate = service.getMaxUpdatedDate(project.getId());
        String jqlParamString = utilComponent.getJqlParamString(project.getId(), maxUpdatedDate);
        map.put(JQL, jqlParamString);
        map.put(MAX_RESULTS, String.valueOf(resultPerPage));
        do {

            map.put(START_AT, String.valueOf(startAt));
            log.info("StartAt:{}, MaxResult:{}, JqlString:{}", startAt, resultPerPage, jqlParamString);
            JiraIssueDetails issues = getIssues(map);

            List<JiraIssueInfo> issueInfoList = issues.getIssues();

            if (CollectionUtils.isEmpty(issueInfoList)) {
                isCompleted = true;
            } else {
                startAt += resultPerPage;
                if (issues.getTotal() < startAt) isCompleted = true;
                log.info("Issues count form server : {}", issueInfoList.size());
                getIssuesAndStoreInDB(issueInfoList);
            }
        } while (!isCompleted);

    }

    public void getJiraIssues() {
        List<Project> projects = getProjects();

        removeIssuesForDeletedProjectsFromDB(projects);

        projects.forEach(project -> {
            log.info("********* Project Name: {}", project.getName());
            getAllIssuesByProjectId(project);
        });
    }

    private void removeIssuesForDeletedProjectsFromDB(List<Project> projects) {

        List<String> projectIdInResponse = projects.stream().map(Project::getId).distinct().collect(Collectors.toList());
        List<String> projectIdInDB = service.getAll().stream().map(JiraIssue::getProjectId).distinct().collect(Collectors.toList());

        projectIdInDB.removeAll(projectIdInResponse);
        projectIdInDB.forEach(deletedProjectId -> service.deleteByProjectId(deletedProjectId));

    }

    private void getAllIssuesKeyByProjectId(Project project) {

        List<String> issueKeysInResponse = new ArrayList<>();

        Map<String, String> map = new HashMap<>();
        int resultPerPage = RESULTS_PER_PAGE;
        int startAt = PAGE_STARTS_AT;
        boolean isCompleted = false;
        String jqlParamString = utilComponent.getJqlParamString(project.getId());
        map.put(JQL, jqlParamString);
        map.put(MAX_RESULTS, String.valueOf(resultPerPage));

        do {
            map.put(START_AT, String.valueOf(startAt));
            JiraIssueDetails issues = getIssues(map);

            List<JiraIssueInfo> issueInfoList = issues.getIssues();

            if (CollectionUtils.isEmpty(issueInfoList)) {
                isCompleted = true;
            } else {
                startAt += resultPerPage;
                if (issues.getTotal() < startAt) isCompleted = true;
                issueKeysInResponse.addAll(issueInfoList.stream().map(JiraIssueInfo::getKey).collect(Collectors.toList()));
            }
        } while (!isCompleted);

        removeDeletedIssuesFromDb(project, issueKeysInResponse);

    }

    private void removeDeletedIssuesFromDb(Project project, List<String> issueKeysInResponse) {

        List<String> issueKeysInDB = service.findByProjectId(project.getId()).stream().map(JiraIssue::getKey).collect(Collectors.toList());
        issueKeysInDB.removeAll(issueKeysInResponse);

        issueKeysInDB.forEach(deletedIssueKey -> {
            service.deleteByKey(deletedIssueKey);
        });

    }
}
