package com.atguigu.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.atguigu.cloud.mapper")
public class ApplicationMain8001 {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationMain8001.class, args);
    }
}
