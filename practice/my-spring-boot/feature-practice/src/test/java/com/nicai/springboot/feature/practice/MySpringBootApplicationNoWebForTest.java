package com.nicai.springboot.feature.practice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MySpringBootApplicationNoWebForTest {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(MySpringBootApplicationNoWebForTest.class);
        springApplication.setWebApplicationType(WebApplicationType.NONE);
        springApplication.run(args);
    }

}
