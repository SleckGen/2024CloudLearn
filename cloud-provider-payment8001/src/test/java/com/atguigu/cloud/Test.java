package com.atguigu.cloud;

import org.junit.platform.commons.annotation.Testable;

import java.time.ZonedDateTime;

@Testable
public class Test {

    public static void main(String[] args) {
        ZonedDateTime zbj = ZonedDateTime.now(); // 默认时区
        System.out.println(zbj);
    }
}
