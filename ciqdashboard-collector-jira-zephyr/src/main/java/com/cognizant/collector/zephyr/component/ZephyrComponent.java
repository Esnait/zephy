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

package com.cognizant.collector.zephyr.component;

import com.cognizant.collector.jira.beans.core.*;
import com.cognizant.collector.jira.client.*;
import com.cognizant.collector.jira.service.*;
import com.cognizant.collector.zephyr.beans.*;
import com.cognizant.collector.zephyr.client.*;
import lombok.extern.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.stereotype.Component;
import org.springframework.util.*;

import java.util.*;
import java.util.stream.*;

import static com.cognizant.collector.jira.constants.Constant.*;

/**
 * ZephyrComponent
 * @author Cognizant
 */

@Component
@Slf4j
public class ZephyrComponent {

    @Autowired
    ZephyrUtilComponent zephyrUtilComponent;
    @Autowired
    JiraClient jiraClient;
    @Autowired
    ZephyrClient zephyrClient;
    @Autowired
    JiraIssueService jiraIssueService;

//    @Value("${zephyrServer.url}")
//    private String zephyrServerUrl;
    @Value("${zephyrServer.accessKey}")
    private String zephyrAccessKey;
    @Value("${zephyrServer.secretKey}")
    private String zephyrSecretKey;

    private Stream<JiraIssue> getTests() {

        Stream<JiraIssue> testLists = jiraIssueService.getAll().stream().filter(jiraIssue -> jiraIssue.getIssueTypeName().equals("Test"));
        return testLists;

    }

    public void getEecutionDetails() {

        getTests().forEach(test -> {

            String endpoint = "?projectId="+test.getProjectId()+"&issueId="+test.getId();

            List<Execution> executionList = Collections.singletonList((Execution) (zephyrClient.getExecutions(
                    Long.valueOf(test.getId()),
                    Long.valueOf(test.getProjectId()),
                    zephyrAccessKey,
                    zephyrUtilComponent.getJWT(endpoint))));
        });

        //TO DO...

    }

}
