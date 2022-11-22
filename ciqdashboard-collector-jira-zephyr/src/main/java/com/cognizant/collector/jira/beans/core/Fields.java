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

package com.cognizant.collector.jira.beans.core;

import com.fasterxml.jackson.annotation.*;
import lombok.*;
import org.springframework.beans.*;

import java.util.*;
/**
 * Fields
 * @author Cognizant
 */

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "issuetype",
        "components",
        "timespent",
        "timeoriginalestimate",
        "description",
        "project",
        "fixVersions",
        "aggregatetimespent",
        "resolution",
        "customfield_10035",
        "timetracking",
        "customfield_10104",
        "customfield_10203",
        "customfield_10105",
        "attachment",
        "aggregatetimeestimate",
        "resolutiondate",
        "workratio",
        "summary",
        "lastViewed",
        "watches",
        "creator",
        "subtasks",
        "created",
        "reporter",
        "customfield_10000",
        "aggregateprogress",
        "priority",
        "customfield_10100",
        "customfield_10201",
        "labels",
        "customfield_10202",
        "environment",
        "timeestimate",
        "aggregatetimeoriginalestimate",
        "versions",
        "duedate",
        "progress",
        "comment",
        "issuelinks",
        "votes",
        "worklog",
        "assignee",
        "updated",
        "status"
})
public class Fields {
    @JsonProperty("issuetype")
    private IssueType issuetype;
    @JsonProperty("components")
    private List<Object> components = null;
    @JsonProperty("timespent")
    private Object timeSpent;
    @JsonProperty("timeoriginalestimate")
    private Object timeOriginalEstimate;
    @JsonProperty("description")
    private String description;
    @JsonProperty("project")
    private Project project;
    @JsonProperty("fixVersions")
    private List<FixVersion> fixVersions = null;
    @JsonProperty("aggregatetimespent")
    private Object aggregateTimeSpent;
    @JsonProperty("resolution")
    private Resolution resolution;
    @JsonProperty("customfield_10035")
    private Object customfield_10035;
    @JsonProperty("timetracking")
    private Object timeTracking;
    @JsonProperty("customfield_10104")
    private Object customField10104;

    @JsonProperty("customfield_10101")
    private List<String> customfield_10101 = null;
    @JsonProperty("customfield_10203")
    private Object customField10203;
    @JsonProperty("customfield_10105")
    private Object customField10105;
    @JsonProperty("attachment")
    private List<Object> attachment = null;
    @JsonProperty("aggregatetimeestimate")
    private Object aggregateTimeEstimate;
    @JsonProperty("resolutiondate")
    private String resolutionDate;
    @JsonProperty("workratio")
    private Long workRatio;
    @JsonProperty("summary")
    private String summary;
    @JsonProperty("lastViewed")
    private Object lastViewed;
    @JsonProperty("watches")
    private Object watches;
    @JsonProperty("creator")
    private User creator;
    @JsonProperty("subtasks")
    private List<Object> subTasks = null;
    @JsonProperty("created")
    private Date created;
    @JsonProperty("reporter")
    private User reporter;
    @JsonProperty("customfield_10000")
    private Object customField10000;
    @JsonProperty("aggregateprogress")
    private Object aggregateProgress;
    @JsonProperty("priority")
    private Object priority;
    @JsonProperty("customfield_10100")
    private Object customField10100;
    @JsonProperty("customfield_10201")
    private Object customField10201;
    @JsonProperty("labels")
    private List<Object> labels = null;
    @JsonProperty("customfield_10202")
    private Object customField10202;
    @JsonProperty("environment")
    private Object environment;
    @JsonProperty("timeestimate")
    private Object timeEstimate;
    @JsonProperty("aggregatetimeoriginalestimate")
    private Object aggregateTimeOriginalEstimate;
    @JsonProperty("versions")
    private List<Object> versions = null;
    @JsonProperty("duedate")
    private Object dueDate;
    @JsonProperty("progress")
    private Object progress;
    @JsonProperty("comment")
    private Object comment;
    @JsonProperty("issuelinks")
    private List<Object> issueLinks = null;
    @JsonProperty("votes")
    private Object votes;
    @JsonProperty("worklog")
    private Object workLog;
    @JsonProperty("assignee")
    private User assignee;
    @JsonProperty("updated")
    private Date updated;
    @JsonProperty("status")
    private Status status;
    private SprintDetails sprintDetails;
    @JsonProperty("customfield_11500")
    private Object customfield_11500;
    @JsonProperty("customfield_10416")
    private Object customfield_10416;
    @JsonProperty("customfield_10417")
    private Object customfield_10417;
    @JsonProperty("customfield_10418")
    private Object customfield_10418;
    @JsonProperty("customfield_10419")
    private Object customfield_10419;
    @JsonProperty("customfield_10106")
    private Double customfield_10106;
    @JsonProperty("customfield_10411")
    private Object customfield_10411;


    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @JsonIgnore
    public JiraIssue getJiraIssue(JiraIssue issue) {
        BeanUtils.copyProperties(this, issue);

        this.setJiraIssueProject(issue);
        this.setJiraIssueIssueType(issue);
        this.setJiraIssueCreator(issue);
        this.setJiraIssueReporter(issue);
        this.setJiraIssueAssignee(issue);
        this.setJiraIssueResolution(issue);
        this.setJiraIssueStatus(issue);
        this.setJiraIssueSprintDetails(issue);
        this.setCustomField(issue);
        this.setJiraIssuePriority(issue);
        this.setJiraIssueFixVersion(issue);
        this.setJiraIssueComponents(issue);
        return issue;
    }

    private JiraIssue setCustomField(JiraIssue issue) {
        String value = "value";

        if (null != customfield_10035) issue.setCustomfield_10035((String) ((Map) customfield_10035).get(value));
        if (null != customfield_11500) issue.setCustomfield_11500((String) ((Map) customfield_11500).get(value));
        if (null != customfield_10416) issue.setCustomfield_10416((String) ((Map) customfield_10416).get(value));
        if (null != customfield_10417) issue.setCustomfield_10417((String) ((Map) customfield_10417).get(value));
        if (null != customfield_10418) issue.setCustomfield_10418((String) ((Map) customfield_10418).get(value));
        if (null != customfield_10419) issue.setCustomfield_10419((String) ((Map) customfield_10419).get(value));
        if (null != customfield_10411) issue.setCustomfield_10411((String) ((Map) customfield_10411).get(value));
        return issue;
    }

    private JiraIssue setJiraIssueSprintDetails(JiraIssue issue) {
        if (null == sprintDetails) return issue;
        issue.setSprintActivatedDate(sprintDetails.getSprintActivatedDate());
        issue.setSprintCompleteDate(sprintDetails.getSprintCompleteDate());
        issue.setSprintEndDate(sprintDetails.getSprintEndDate());
        issue.setSprintGoal(sprintDetails.getSprintGoal());
        issue.setSprintId(sprintDetails.getSprintId());
        issue.setSprintName(sprintDetails.getSprintName());
        issue.setSprintRapidViewId(sprintDetails.getSprintRapidViewId());
        issue.setSprintSequence(sprintDetails.getSprintSequence());
        issue.setSprintStartDate(sprintDetails.getSprintStartDate());
        issue.setSprintState(sprintDetails.getSprintState());

        return issue;
    }

    @JsonIgnore
    private JiraIssue setJiraIssueStatus(JiraIssue issue) {
        /* status */
        if (null == status) return issue;
        issue.setStatusDescription(status.getDescription());
        issue.setStatusIconUrl(status.getIconUrl());
        issue.setStatusId(status.getId());
        issue.setStatusName(status.getName());
        issue.setStatusSelf(status.getSelf());

        /* statusCategory */
        StatusCategory statusCategory = status.getStatusCategory();
        if (null == statusCategory) return issue;
        issue.setStatusCategoryColorName(statusCategory.getColorName());
        issue.setStatusCategoryId(statusCategory.getId());
        issue.setStatusCategoryKey(statusCategory.getKey());
        issue.setStatusCategoryName(statusCategory.getName());
        issue.setStatusCategorySelf(statusCategory.getSelf());
        /* statusCategory */
        /* status */
        return issue;
    }

    @JsonIgnore
    private JiraIssue setJiraIssueResolution(JiraIssue issue) {
        /* resolution */
        if (null == resolution) return issue;
        issue.setResolutionDescription(resolution.getDescription());
        issue.setResolutionId(resolution.getId());
        issue.setResolutionName(resolution.getName());
        issue.setResolutionSelf(resolution.getSelf());
        /* resolution */
        return issue;
    }

    @JsonIgnore
    private JiraIssue setJiraIssueAssignee(JiraIssue issue) {
        /* assignee */
        if (null == assignee) return issue;
        issue.setAssigneeActive(assignee.getActive());
        issue.setAssigneeAvatarUrls(assignee.getAvatarUrls());
        issue.setAssigneeDisplayName(assignee.getDisplayName());
        issue.setAssigneeEmailAddress(assignee.getEmailAddress());
        issue.setAssigneeKey(assignee.getKey());
        issue.setAssigneeName(assignee.getName());
        issue.setAssigneeSelf(assignee.getSelf());
        issue.setAssigneeTimeZone(assignee.getTimeZone());
        /* assignee */
        return issue;
    }

    @JsonIgnore
    private JiraIssue setJiraIssueReporter(JiraIssue issue) {
        /* reporter */
        if (null == reporter) return issue;
        issue.setReporterActive(reporter.getActive());
        issue.setReporterAvatarUrls(reporter.getAvatarUrls());
        issue.setReporterDisplayName(reporter.getDisplayName());
        issue.setReporterEmailAddress(reporter.getEmailAddress());
        issue.setReporterKey(reporter.getKey());
        issue.setReporterName(reporter.getName());
        issue.setReporterSelf(reporter.getSelf());
        issue.setReporterTimeZone(reporter.getTimeZone());
        /* reporter */
        return issue;
    }

    @JsonIgnore
    private JiraIssue setJiraIssueCreator(JiraIssue issue) {
        /* creator */
        if (null == creator) return issue;
        issue.setCreatorActive(creator.getActive());
        issue.setCreatorAvatarUrls(creator.getAvatarUrls());
        issue.setCreatorDisplayName(creator.getDisplayName());
        issue.setCreatorEmailAddress(creator.getEmailAddress());
        issue.setCreatorKey(creator.getKey());
        issue.setCreatorName(creator.getName());
        issue.setCreatorSelf(creator.getSelf());
        issue.setCreatorTimeZone(creator.getTimeZone());
        /* creator */
        return issue;
    }

    @JsonIgnore
    private JiraIssue setJiraIssueIssueType(JiraIssue issue) {
        /* issueType */
        IssueType issueType = this.issuetype;
        if (null == issueType) return issue;
        issue.setIssueTypeId(issueType.getId());
        issue.setIssueTypeSelf(issueType.getSelf());
        issue.setIssueTypeName(issueType.getName());
        issue.setIssueTypeAvatarId(issueType.getAvatarId());
        issue.setIssueTypeDescription(issueType.getDescription());
        issue.setIssueTypeIconUrl(issueType.getIconUrl());
        issue.setIssueTypeSubtask(issueType.getSubtask());
        /* issueType */
        return issue;
    }

    @JsonIgnore
    private JiraIssue setJiraIssueProject(JiraIssue issue) {
        /* project */
        if (null == project) return issue;
        issue.setProjectId(project.getId());
        issue.setProjectKey(project.getKey());
        issue.setProjectName(project.getName());
        issue.setProjectSelf(project.getSelf());
        issue.setProjectAvatarUrls(project.getAvatarUrls());
        issue.setProjectTypeKey(project.getProjectTypeKey());
        /* project */
        return issue;
    }

    @JsonIgnore
    private JiraIssue setJiraIssuePriority(JiraIssue issue) {
        if (priority == null) return issue;
        issue.setPriority((String) ((Map) priority).get("name"));
        issue.setPriorityId((String) ((Map) priority).get("id"));
        return issue;
    }

    @JsonIgnore
    private JiraIssue setJiraIssueFixVersion(JiraIssue issue) {
        if (fixVersions == null || fixVersions.size() <= 0) return issue;

        fixVersions.stream().findFirst().ifPresent(first -> {
            issue.setFixVersionId(first.getId());
            issue.setFixVersionName(first.getName());
            issue.setFixVersionArchived(first.isArchived());
            issue.setFixVersionReleased(first.isReleased());
            issue.setFixVersionReleaseDate(first.getReleaseDate());
        });

        return issue;
    }

    @JsonIgnore
    private JiraIssue setJiraIssueComponents(JiraIssue issue) {
        if (components == null || components.size() <= 0) return issue;
        issue.setComponentId((String) ((Map) components.get(0)).get("id"));
        issue.setComponentName((String) ((Map) components.get(0)).get("name"));
        return issue;
    }
}

