package com.example.orchestrator.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
public class MyController {

    private Map<String, List<Map<String, String>>> values;

    @Autowired
    public MyController() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        this.values = objectMapper.readValue(this.getClass().getClassLoader().getResourceAsStream("application.json"), Map.class);
    }

    @RequestMapping("/myendpoint")
    public Map showValues() {
        return this.values;
    }
}
