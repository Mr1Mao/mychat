package com.mao.mychat;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.mao.mychat.mapper")
public class MyChatApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyChatApplication.class, args);
    }
}
