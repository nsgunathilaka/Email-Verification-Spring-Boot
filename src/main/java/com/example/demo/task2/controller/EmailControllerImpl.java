package com.example.demo.task2.controller;

import com.example.demo.task2.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class EmailControllerImpl implements EmailController{

    @Autowired
    EmailService emailService;
    @Override
    public String validateEmail(Map<String, String> requestMap) {

        try{
            return emailService.validateEmail(requestMap);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
