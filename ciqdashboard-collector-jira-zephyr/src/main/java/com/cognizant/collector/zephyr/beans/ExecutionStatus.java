package com.cognizant.collector.zephyr.beans;

import com.cognizant.collector.zephyr.util.*;
import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.*;
import lombok.*;

@Data
@JsonDeserialize(using = ExecutionStatusDesirializer.class)
public class ExecutionStatus {

    @JsonProperty("name")
    private String Name;
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("description")
    private String description;

}
