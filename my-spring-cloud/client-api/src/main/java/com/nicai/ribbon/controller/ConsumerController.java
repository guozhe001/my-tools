package com.nicai.ribbon.controller;


import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
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

    @Value("${server.api.host}")
    @Setter
    @Getter
    private String serverApiName;

    private final RestTemplate restTemplate;

    public ConsumerController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("hi")
    @ResponseBody
    public String hi() {
        ResponseEntity<String> forEntity = restTemplate.getForEntity(String.format("%s/hello", serverApiName), String.class);
        return forEntity.getBody();
    }


}
