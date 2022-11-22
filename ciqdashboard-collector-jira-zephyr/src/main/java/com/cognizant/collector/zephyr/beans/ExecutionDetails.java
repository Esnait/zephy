package com.cognizant.collector.zephyr.beans;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.*;
import lombok.*;
import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.mapping.*;

import java.util.*;

@Data
@Document(collection = "#{T(com.cognizant.collector.zephyr.component.ZephyrUtilComponent).getCollectionName()}")
public class ExecutionDetails {

    @Id
    private String objectId;

    @JsonProperty("execution")
    private Issue issue;

    @JsonProperty("executionStatus")
    private ExecutionStatus executionStatus;

}
