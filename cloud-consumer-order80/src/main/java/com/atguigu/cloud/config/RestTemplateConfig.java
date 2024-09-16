package com.atguigu.cloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {
    @Bean
    @LoadBalanced//开启支持负载均衡 （使用consul默认开启 如果不加会报错）
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
