package com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLOutput;

@SpringBootApplication
@MapperScan("com.mapper")
public class CbeCommerceApplication {

    public static void main(String[] args) {
        System.out.println("##############");
        SpringApplication.run(CbeCommerceApplication.class, args);
    }
}
