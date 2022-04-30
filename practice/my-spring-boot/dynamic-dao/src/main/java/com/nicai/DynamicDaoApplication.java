package com.nicai;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author guozhe
 * @date 2020-04-27
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@MapperScan("com.nicai.mapper")
public class DynamicDaoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DynamicDaoApplication.class, args);
    }
}
