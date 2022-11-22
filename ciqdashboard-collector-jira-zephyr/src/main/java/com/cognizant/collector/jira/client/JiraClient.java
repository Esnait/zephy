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

package com.cognizant.collector.jira.client;

import com.cognizant.collector.jira.beans.Project;
import com.cognizant.collector.jira.beans.core.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;
/**
 * JiraClient - Refers to jira server API's
 * @author Cognizant
 */

public interface JiraClient {

    @GetMapping("/project")
    List<Project> getJiraProjects();

    @GetMapping("/search")
    JiraIssueDetails getJiraIssues(@RequestParam Map<String, String> requestParams);

    @GetMapping("/myself")
    Object getAcccountID();

    @GetMapping("/project/{projectID}/versions")
    List<Object> getProjectVersions(@PathVariable String projectID);

}
