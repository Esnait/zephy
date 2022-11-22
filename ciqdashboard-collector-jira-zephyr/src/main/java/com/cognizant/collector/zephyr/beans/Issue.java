package com.cognizant.collector.zephyr.beans;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

@Data
public class Issue {

    @JsonProperty("execution")
    Execution execution;

    @JsonProperty("issueKey")
    private String issueKey;
    @JsonProperty("issueLabel")
    private String issueLabel;
    @JsonProperty("component")
    private String component;
    @JsonProperty("issueSummary")
    private String issueSummary;
    @JsonProperty("projectKey")
    private String projectKey;
    @JsonProperty("projectName")
    private String projectName;
    @JsonProperty("versionName")
    private String versionName;
    @JsonProperty("priority")
    private String priority;
    @JsonProperty("executedByDisplayName")
    private String executedBy;
    @JsonProperty("testStepBeans")
    private Object testStepBeans;
    @JsonProperty("defectsAsString")
    private String defect;

}
