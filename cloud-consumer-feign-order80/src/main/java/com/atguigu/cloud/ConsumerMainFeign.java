package com.atguigu.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient//该注解用于向使用consul为注册中心时注册服务
@EnableFeignClients//启动feign客户端。定义服务+绑定接口，以声明式的方法优雅而简单的实现服务调用
public class ConsumerMainFeign {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerMainFeign.class,args);
    }
}
