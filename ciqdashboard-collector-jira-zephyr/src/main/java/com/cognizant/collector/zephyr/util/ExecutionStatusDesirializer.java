package com.cognizant.collector.zephyr.util;

import com.cognizant.collector.zephyr.beans.*;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.node.*;

import java.io.*;

public class ExecutionStatusDesirializer extends JsonDeserializer<ExecutionStatus> {

    @Override
    public ExecutionStatus deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {

        JsonNode jsonNode = jsonParser.getCodec().readTree(jsonParser);

        ArrayNode entities = (ArrayNode) jsonNode.get(0);


        //TO DO...


        return null;

    }
}
