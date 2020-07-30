package com.nicai.springboot.feature.practice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author guozhe
 * @date 2020/07/23
 */
@Slf4j
@Controller
@RequestMapping("/api/")
public class HelloController {

    @PostMapping("hello")
    @ResponseBody
    public String hello() {
        log.info("hello!");
        return "hello";
    }
}
