package com.nicai.controller;

import com.alibaba.fastjson.JSON;
import com.nicai.DynamicDaoApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.MockMvcPrint;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

/**
 * CustomerControllerTest
 *
 * @author guozhe
 * @date 2020/10/21
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DynamicDaoApplication.class)
@AutoConfigureMockMvc(print = MockMvcPrint.NONE)
public class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void add() throws Exception {
        // 调用add
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/add")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .param("name", "test")
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        MockHttpServletResponse response = mvcResult.getResponse();
        log.info("response={}", JSON.toJSONString(response));
        Assert.assertEquals(200, response.getStatus());
    }

    @Test
    public void hello() throws Exception {
        // 调用add
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        MockHttpServletResponse response = mvcResult.getResponse();
        log.info("response={}", JSON.toJSONString(response));
        Assert.assertEquals(200, response.getStatus());
    }
}