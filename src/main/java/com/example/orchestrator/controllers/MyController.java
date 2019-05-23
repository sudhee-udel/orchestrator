package com.example.orchestrator.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
public class MyController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private Map<String, List<Map<String, String>>> values;

    @Autowired
    public MyController() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        this.values = objectMapper.readValue(this.getClass().getClassLoader().getResourceAsStream("application.json"), Map.class);
    }

    @RequestMapping("/myendpoint")
    public Object showValues(HttpServletRequest httpServletRequest) {
        logger.info(httpServletRequest.getRequestURI());
        return this.values.get(httpServletRequest.getRequestURI());
    }

    @RequestMapping("/myendpoint2")
    public Object showValues2(HttpServletRequest httpServletRequest) {
        logger.info(httpServletRequest.getRequestURI());
        return this.values.get(httpServletRequest.getRequestURI());
    }
}
