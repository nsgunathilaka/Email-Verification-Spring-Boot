package com.example.demo.task2.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@RequestMapping(path = "/email")
public interface EmailController {

    @PostMapping(path = "/validateEmail")
    public String validateEmail(@RequestBody(required = true) Map<String, String> requestMap);
}
