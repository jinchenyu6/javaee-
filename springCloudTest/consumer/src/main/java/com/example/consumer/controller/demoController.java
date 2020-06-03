package com.example.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class demoController {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("greet")
    public String sayHello(@RequestParam String name){

        return restTemplate.getForObject("http://EUREKA-PRODUCER/sayHello?param=" + name, String.class);
    }

}