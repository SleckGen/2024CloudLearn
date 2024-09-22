package com.atguigu.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.consul.ConditionalOnConsulEnabled;

@SpringBootApplication
@EnableDiscoveryClient
public class MainGateway9527 {
    public static void main(String[] args) {
        SpringApplication.run(MainGateway9527.class, args);
    }
}
