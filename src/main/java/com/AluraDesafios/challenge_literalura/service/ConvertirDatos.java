package com.AluraDesafios.challenge_literalura.service;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class ConvertirDatos {

    ObjectMapper objectMapper = new ObjectMapper().enable(JsonParser.Feature.INCLUDE_SOURCE_IN_LOCATION);


    public <T> T obtenerDatos(String json, Class<T> clase) {
        try {
            return objectMapper.readValue(json,clase);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
