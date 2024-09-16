package com.atguigu.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.consul.ConditionalOnConsulEnabled;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import tk.mybatis.spring.annotation.MapperScan;

@RefreshScope //重写刷新配置 但是不加也是一样刷新
@SpringBootApplication
@ConditionalOnConsulEnabled
@MapperScan("com.atguigu.cloud.mapper")
public class ApplicationMain8002 {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationMain8002.class,args);
    }
}
