package com.nicai.springboot.feature.practice.controller;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.nicai.springboot.feature.practice.vo.UserModel;
import io.swagger.annotations.ApiOperation;

/**
 * @author guozhe
 * @date 2020/07/23
 */
@Slf4j
@Controller
@Api
@RequestMapping("/api/")
public class HelloController {

    @PostMapping("hello")
    @ResponseBody
    public String hello() {
        log.info("hello!");
        return "hello";
    }


    @PostMapping("get")
    @ResponseBody
    @ApiOperation("")
    public UserModel get() {
        log.info("hello!");
        UserModel userModel = new UserModel();
        userModel.setGender("男");
        return userModel;
    }

}
