package com.atguigu.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MainConfigCenter {
    public static void main(String[] args) {
        SpringApplication.run(MainConfigCenter.class,args);
    }
}
