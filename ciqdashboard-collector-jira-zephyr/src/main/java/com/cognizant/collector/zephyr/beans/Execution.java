package com.cognizant.collector.zephyr.beans;

import com.fasterxml.jackson.annotation.*;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.*;

import java.util.*;

@Data
public class Execution {

    @JsonProperty("id")
    private String id;
    @JsonProperty("issueId")
    private Long issueId;
    @JsonProperty("versionId")
    private Integer versionId;
    @JsonProperty("projectId")
    private Long projectId;
    @JsonProperty("cycleId")
    private String cycleId;
    @JsonProperty("orderId")
    private Integer orderId;
    @JsonProperty("executedBy")
    private String executedBy;
    @JsonProperty("executedByAccountId")
    private String executedByAccountId;
    @JsonProperty("executedOn")
    private Date executedOn;
    @JsonProperty("modifiedBy")
    private String modifiedBy;
    @JsonProperty("modifiedByAccountId")
    private String modifiedByAccountId;
    @JsonProperty("createdBy")
    private String createdBy;
    @JsonProperty("createdByAccountId")
    private String createdByAccountId;
    @JsonProperty("status")
    Object status;

    public void setStatus(Object status) {
        this.status = ((Map) status).get("name");
    }

    @JsonProperty("cycleName")
    private String cycleName;

//    @JsonProperty("defects")
//    List<Object> defects;
//
//    public void setDefects(List<Object> defects) {
//
//        List<Map<String, Object>> defects = new ArrayList<>();
//
//
//        this.defects = defects;
//    }

//    "": [
//    {
//        "id": 10001,
//            "key": "TEST-2",
//            "summary": "BBB",
//            "status": {
//        "self": "http://192.168.1.68:2990/jira/rest/api/2/status/10000",
//                "name": "To Do",
//                "id": 10000,
//                "description": "",
//                "iconUrl": "http://192.168.1.68:2990/jira/images/icons/status_generic.gif"
//    }
//    }
//      ],

    @JsonProperty("stepDefects")
    private List<Object> stepDefects;
    @JsonProperty("executionDefectCount")
    private Integer executionDefectCount;
    @JsonProperty("stepDefectCount")
    private Integer stepDefectCount;
    @JsonProperty("totalDefectCount")
    private Integer totalDefectCount;
    @JsonProperty("tenantKey")
    private String tenantKey;
    @JsonProperty("creationDate")
    private Date creationDate;
    @JsonProperty("issueIndex")
    private Long issueIndex;
    @JsonProperty("projectCycleVersionIndex")
    private String projectCycleVersionIndex;
    @JsonProperty("executionStatusIndex")
    private Long executionStatusIndex;
    @JsonProperty("projectIssueCycleVersionIndex")
    private String projectIssueCycleVersionIndex;


}
