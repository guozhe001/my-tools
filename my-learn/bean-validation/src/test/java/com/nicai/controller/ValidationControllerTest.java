package com.nicai.controller;


import com.nicai.ValidationApplication;
import com.nicai.ao.UserAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * @author guozhe
 * @date 2019-12-16
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ValidationApplication.class)
public class ValidationControllerTest {
    @Autowired
    private ValidationController validationController;

    @Test(expected = Exception.class)
    public void pushToPaySource() {
        validationController.pushToPaySource("hi");
    }

    @Test(expected = Exception.class)
    public void receiveUser() {
        UserAO userAO = new UserAO();
        validationController.receiveUser(userAO);
    }

}