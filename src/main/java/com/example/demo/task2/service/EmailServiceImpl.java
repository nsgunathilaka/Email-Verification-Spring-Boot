package com.example.demo.task2.service;

import com.example.demo.task2.model.Email;
import com.example.demo.task2.repository.EmailRepository;
import com.example.demo.task2.utils.EmailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.border.MatteBorder;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class EmailServiceImpl implements EmailService{

    @Autowired
    EmailRepository emailRepository;

    @Autowired
    EmailUtil emailUtil;


    @Override
    public String validateEmail(Map<String, String> requestMap) {
        try {
            if (!requestMap.get("email").isEmpty()) {
                emailRepository.save(emailFromMap(requestMap));

                String regex = "^(.+)@(.+)$";
                Pattern pattern = Pattern.compile(regex);

                Matcher matcher = pattern.matcher(requestMap.get("email"));
                if (matcher.matches()) {
                    emailUtil.sendSimpleEmail(requestMap.get("email").toString(),"Valid Account","This is a validate email address");
                    return "Email Sent";
                } else {
                    return "Email is not valid";
                }




            } else {
                return "Email field is empty";
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Something went wrong";
    }


    private Email emailFromMap(Map<String, String> requestMap) {
        Email email = new Email();
        email.setEmail(requestMap.get("email"));
        return email;
    }
}
