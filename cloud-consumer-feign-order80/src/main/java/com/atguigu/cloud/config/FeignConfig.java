package com.atguigu.cloud.config;

import feign.Logger;
import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {

    @Bean
    public Retryer myRetryer() {
        // 设置Feign的重试策略：初始间隔100毫秒，最大间隔1000毫秒，最多重试3次
//        return new Retryer.Default(100, 1000, 3);
        return Retryer.NEVER_RETRY;
    }

    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
}
