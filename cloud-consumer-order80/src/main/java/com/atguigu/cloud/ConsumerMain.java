package com.atguigu.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.consul.ConditionalOnConsulEnabled;

@SpringBootApplication
@ConditionalOnConsulEnabled
public class ConsumerMain {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerMain.class,args);
    }
}
