package com.guozhe.practice;

import com.guozhe.practice.notify.NotifyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@Slf4j
@SpringBootApplication
public class PracticeApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(PracticeApplication.class, args);
        NotifyService bean = context.getBean(NotifyService.class);
        log.info(bean.getClass().toString());
    }


}
