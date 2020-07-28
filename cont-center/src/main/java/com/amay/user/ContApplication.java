package com.amay.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableDiscoveryClient
@MapperScan("com.amay.cont.dao")
public class ContApplication {

    public static void main(String[] args) {
        SpringApplication.run(ContApplication.class, args);
    }

}
