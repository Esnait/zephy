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

import com.cognizant.collector.jira.beans.core.*;
import lombok.extern.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.util.*;

import java.text.*;
import java.time.*;
import java.time.format.*;
import java.util.*;
import java.util.stream.*;

import static com.cognizant.collector.jira.constants.Constant.*;
/**
 * CommonUtilComponent
 * @author Cognizant
 */

@Component
@Slf4j
public class CommonUtilComponent {

    static String collectionName;

    public String parseDateToString(Date date) {
        if (null == date) return "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        return sdf.format(date);
    }

    public Date getDateFromString(String dateString) {
        Date date = null;
        try {
            LocalDateTime dateTime = LocalDateTime.parse(dateString, DateTimeFormatter.ISO_DATE_TIME);
            date = Date.from(dateTime.atZone(ZoneId.systemDefault()).toInstant());
        } catch (DateTimeParseException e) {
            log.info("Return value as null, due to exception while parsing string to date, Exception:{}");
        }
        return date;
    }

    public Integer getIntegerFromString(String integerString) {
        Integer integer = null;
        try {
            integer = Integer.valueOf(integerString);
        } catch (NumberFormatException e) {
            log.info("Return value as null, due to exception while parsing string to integer, Exception:{}");
        }
        return integer;
    }

    public Map<String, String> getMap(String input) {
        Map<String, String> map = new HashMap<>();
        if (!(input.contains("[") && input.contains("]"))) return map;

        String[] strings = input.substring(input.indexOf('[') + 1, input.indexOf(']')).split(",");
        List<String> list = Arrays.asList(strings);
        list.forEach(s -> {
            String[] split = s.split("=");
            String key = split[0];
            if (split.length == 2) {
                String value = split[1].equals("<null>") ? null : split[1];
                map.put(key, value);
            }
        });

        return map;
    }

    public String getJqlParamString(String projectId, Date lastUpdatedDate) {
        List<String> jqlParams = new ArrayList<>();
        jqlParams.add(String.format(PROJECT, projectId));

        Date now = Calendar.getInstance().getTime();
        String nowDateSting = parseDateToString(now);
        jqlParams.add(String.format(JQL_UPDATED_LT, nowDateSting));
        if (!StringUtils.hasLength(lastUpdatedDate.toString())) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(lastUpdatedDate);
            calendar.add(Calendar.MINUTE, 1);
            String updatedDateString = parseDateToString(calendar.getTime());
            jqlParams.add(String.format(JQL_UPDATED_GTE, updatedDateString));
        }

        String jqlString = jqlParams.stream().collect(Collectors.joining(JQL_AND));
        log.info("JQL string : " + jqlString);
        return jqlString;
    }

    public String getJqlParamString(String projectId) {
        String jqlParam = String.format(PROJECT, projectId);
        return jqlParam;
    }

    public SprintDetails getSprintDetailsFromString(String input){
        if (StringUtils.hasLength(input)) return null;
        SprintDetails sprintDetails = new SprintDetails();
        Map<String, String> map = getMap(input);
        String id = map.get("id");
        String rapidViewId = map.get("rapidViewId");
        String state = map.get("state");
        String name = map.get("name");
        String startDate = map.get("startDate");
        String endDate = map.get("endDate");
        String completeDate = map.get("completeDate");
        String activatedDate = map.get("activatedDate");
        String sequence = map.get("sequence");
        String goal = map.get("goal");

        sprintDetails.setSprintId(getIntegerFromString(id));
        sprintDetails.setSprintRapidViewId(getIntegerFromString(rapidViewId));
        sprintDetails.setSprintSequence(getIntegerFromString(sequence));

        sprintDetails.setSprintActivatedDate(getDateFromString(activatedDate));
        sprintDetails.setSprintCompleteDate(getDateFromString(completeDate));
        sprintDetails.setSprintEndDate(getDateFromString(endDate));
        sprintDetails.setSprintStartDate(getDateFromString(startDate));

        sprintDetails.setSprintGoal(goal);
        sprintDetails.setSprintName(name);
        sprintDetails.setSprintState(state);

        return sprintDetails;
    }

    @Value("${spring.data.mongodb.collection.jira.issues}")
    public void setCollectionName(String collectionName) {
        this.collectionName = SOURCE+collectionName;
    }

    public static String getCollectionName(){
        return collectionName;
    }
}
