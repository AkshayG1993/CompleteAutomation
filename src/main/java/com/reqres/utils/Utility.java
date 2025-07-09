package com.reqres.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Utility {
    static Map<String, String> endpoints = new HashMap<>();

    @SneakyThrows
    public static void extractEndpoints(String filePath) {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(new File(filePath));
        JsonNode endpointsNode = root.get("endpoints");
        if (endpointsNode != null && endpointsNode.isObject()) {
            Iterator<Map.Entry<String, JsonNode>> fields = endpointsNode.fields();
            while (fields.hasNext()) {
                Map.Entry<String, JsonNode> entry = fields.next();
                endpoints.put(entry.getKey(), entry.getValue().asText());
            }
        }
    }

    public static String getEndpoint(String key) {
        if(endpoints.isEmpty()) {
            extractEndpoints("src/main/resources/endpoints.json");
        }
        return endpoints.getOrDefault(key, null);
    }

    @SneakyThrows
    public static String getJsonBody(Object object){
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(object);
    }

    public static String getRandomJob() {
        return "Job_" + System.currentTimeMillis();
    }

    public static String getRandomName() {
        return "Name_" + System.currentTimeMillis();
    }

    public static String getRandomEmail() {
        return "user_" + System.currentTimeMillis() + "@reqres.in";
    }

    public static String getConstantEmail() {
        return "eve.holt@reqres.in";
    }

    public static String getRandomPassword() {
        return "Pass_" + System.currentTimeMillis();
    }
}
