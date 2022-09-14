package com.cskaa.mailchimp_demo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/userdashboard")
public class UserController {

//    @PostMapping(value = "/mail-processing")
//    public void mailProcessing(@RequestParam MandrillEvents mailEvents, HttpServletRequest request){
//        System.out.println(mailEvents);
//    }

    @RequestMapping(value = "/health",method = RequestMethod.GET)
    public void getHealth(HttpServletResponse response){

        System.out.println("Application is running");
        try {
            response.getWriter().println("Application is running");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @RequestMapping(value = "/mail-processing", method = RequestMethod.POST)
    public void mailProcessing(HttpServletRequest request,HttpServletResponse response){
        String body = null;
        try {
            body = request.getReader().lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        ObjectMapper mapper = new JsonMapper();
        try {
            JsonNode json = mapper.readTree(body);
            System.out.println(json);
            response.getWriter().println("Application is running");
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
