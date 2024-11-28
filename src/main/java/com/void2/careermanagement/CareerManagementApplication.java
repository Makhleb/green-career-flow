package com.vo2d.careermanagement;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.vo2d.careermanagement.dao")
@SpringBootApplication
public class CareerManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(CareerManagementApplication.class, args);
    }

}
