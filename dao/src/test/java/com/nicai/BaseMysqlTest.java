package com.nicai;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApplicationWithMapperScanTest.class)
public class BaseMysqlTest {

    @Test
    public void hello() {
        log.info("hello");
    }
}
