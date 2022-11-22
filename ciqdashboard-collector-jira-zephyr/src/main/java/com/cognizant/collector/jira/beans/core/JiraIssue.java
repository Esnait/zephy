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
import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.mapping.*;

import java.util.*;
/**
 * JiraIssue - Refers to jiraIssue collection in mongodb
 * @author Cognizant
 */

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Document(collection = "#{T(com.cognizant.collector.jira.component.CommonUtilComponent).getCollectionName()}")
public class JiraIssue {

    @Id
    private String id;
    private String expand;
    private String self;
    private String key;

    /* Fields */

    /* project */
    private String projectSelf;
    private String projectId;
    private String projectKey;
    private String projectName;
    private String projectTypeKey;
    private Map<String, String> projectAvatarUrls;
    /* project */

    /* issueType */
    private String issueTypeSelf;
    private String issueTypeId;
    private String issueTypeDescription;
    private String issueTypeIconUrl;
    private String issueTypeName;
    private Boolean issueTypeSubtask;
    private Integer issueTypeAvatarId;
    /* issueType */

    /*components*/
    private String componentId;
    private String componentName;
    /*components*/

    private Object timeSpent;
    private Object timeOriginalEstimate;
    private String description;

    /*Fix Version*/
    private String fixVersionId;
    private String fixVersionName;
    private boolean fixVersionArchived;
    private boolean fixVersionReleased;
    private Date fixVersionReleaseDate;
    /*Fix Version*/

    private Object aggregateTimeSpent;
    private Object timeTracking;
    private List<String> customField10104 = null;
    private Object customField10203;
    private Object customField10105;
    private List<Object> attachment = null;
    private Object aggregateTimeEstimate;
    private Date resolutionDate;
    private Long workRatio;
    private String summary;
    private Object lastViewed;
    private Object watches;
    private List<Object> subTasks = null;
    private Object customField10000;
    private Object aggregateProgress;

    /* Priority */
    private String priority;
    private String priorityId;
    /* Priority */

    private Object customField10100;
//    private Object customField10201;
    private List<Object> labels = null;
    private Object customField10202;
    private Object environment;
    private Object timeEstimate;
    private Object aggregateTimeOriginalEstimate;
    private List<Object> versions = null;
    private Object dueDate;
    private Object progress;
    private Object comment;
    private List<Object> issueLinks = null;
    private Object votes;
    private Object workLog;

    private Date created;
    private Date updated;

    /* Sprint Details */
    private Integer sprintId;
    private Integer sprintRapidViewId;
    private String sprintState;
    private String sprintName;
    private Integer sprintSequence;
    private Object sprintGoal;
    private Date sprintStartDate;
    private Date sprintEndDate;
    private Date sprintCompleteDate;
    private Date sprintActivatedDate;
    /* Sprint Details */

    /* creator */
    private String creatorSelf;
    private String creatorName;
    private String creatorKey;
    private String creatorEmailAddress;
    private Map<String, String> creatorAvatarUrls;
    private String creatorDisplayName;
    private Boolean creatorActive;
    private String creatorTimeZone;
    /* creator */

    /* reporter */
    private String reporterSelf;
    private String reporterName;
    private String reporterKey;
    private String reporterEmailAddress;
    private Map<String, String> reporterAvatarUrls;
    private String reporterDisplayName;
    private Boolean reporterActive;
    private String reporterTimeZone;
    /* reporter */

    /* assignee */
    private String assigneeSelf;
    private String assigneeName;
    private String assigneeKey;
    private String assigneeEmailAddress;
    private Map<String, String> assigneeAvatarUrls;
    private String assigneeDisplayName;
    private Boolean assigneeActive;
    private String assigneeTimeZone;
    /* assignee */

    /* resolution */
    private String resolutionSelf;
    private String resolutionId;
    private String resolutionDescription;
    private String resolutionName;
    /* resolution */

    /* status */
    private String statusSelf;
    private String statusDescription;
    private String statusIconUrl;
    private String statusName;
    private String statusId;

    /* statusCategory */
    private String statusCategorySelf;
    private Integer statusCategoryId;
    private String statusCategoryKey;
    private String statusCategoryColorName;
    private String statusCategoryName;
    /* statusCategory */
    /* status */

    /* Fields */
    private String customfield_11500;
    private String customfield_10424;
    private String customfield_10416;
    private String customfield_10417;
    private String customfield_10418;
    private String customfield_10419;
    private Double customfield_10106;
    private String customfield_10411;
    private String customfield_10035;


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
}

