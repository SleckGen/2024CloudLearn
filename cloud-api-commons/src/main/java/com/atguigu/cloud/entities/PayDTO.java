package com.atguigu.cloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/*
*
* 一般而言，调用者不应该熟悉服务提供者的entity资源并知道表结构关系，所以服务提供方给出的
*       接口文档都应该成为DTO
*
* */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PayDTO {

    private Integer id;

    //支付流水号
    private String payNo;

    //订单流水号
    private String orderNo;

    //用户账号ID
    private Integer userId;

    //交易金额
    private BigDecimal amount;
}
