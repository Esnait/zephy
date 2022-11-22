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

package com.cognizant.collector.jira.repo;

import com.cognizant.collector.jira.beans.core.*;
import org.springframework.data.mongodb.repository.*;

import java.util.*;

/**
 * JiraRepository
 * @author Cognizant
 */

public interface JiraIssueRepository extends MongoRepository<JiraIssue, String> {

//    JiraIssue findFirstByProjectKeyOrderByUpdatedDesc(String projectKey);

    JiraIssue findFirstByProjectIdOrderByUpdatedDesc(String projectId);

    List<JiraIssue> deleteByProjectId(String projectId);

    List<JiraIssue> findByProjectId(String projectId);
    List<JiraIssue> deleteByKey(String key);

    List<JiraIssue> findByProjectIdAndIssueTypeName(String projectId, String issueTypeName);
}
