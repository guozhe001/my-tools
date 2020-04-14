package com.nicai.experience;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author guozhe
 * @date 2020-04-14
 */
@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class MyApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyApplication.class, args);
    }
}
