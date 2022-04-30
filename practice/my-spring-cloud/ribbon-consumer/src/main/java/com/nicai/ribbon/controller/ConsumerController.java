package com.nicai.ribbon.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author guozhe
 */
@RestController
public class ConsumerController {

    private final RestTemplate restTemplate;

    public ConsumerController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("hi")
    @ResponseBody
    public String hi() {
        ResponseEntity<String> forEntity = restTemplate.getForEntity("http://TEST-EUREKA-CLIENT/hello", String.class);
        return forEntity.getBody();
    }


}
