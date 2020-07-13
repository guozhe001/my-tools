package com.nicai.springboot.feature.practice;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author guozhe
 * @date 2020-04-27
 */
@SpringBootTest(classes = FeaturePracticeApplication.class)
@RunWith(SpringRunner.class)
public class BaseWithWebTest {

    @Test
    public void contextLoads() {
        Assert.assertTrue(true);
    }

}
