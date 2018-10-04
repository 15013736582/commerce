package com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

import java.sql.SQLOutput;

//@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@SpringBootApplication
@MapperScan("com.mapper")
public class CbeCommerceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CbeCommerceApplication.class, args);
    }
}
