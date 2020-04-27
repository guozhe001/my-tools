package com.nicai.springboot.feature.practice;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = MySpringBootApplicationNoWebForTest.class)
@RunWith(SpringRunner.class)
public class BaseNoWebTest {

    @Test
    public void contextLoads() {

    }

}
