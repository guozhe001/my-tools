package com.nicai;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;

@Slf4j
@SpringBootApplication(scanBasePackages = {"com.nicai"},
        exclude = {DataSourceAutoConfiguration.class,
                DataSourceTransactionManagerAutoConfiguration.class,
                MybatisAutoConfiguration.class})
public class ApplicationWithMapperScanTest {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationWithMapperScanTest.class, args);
    }
}
