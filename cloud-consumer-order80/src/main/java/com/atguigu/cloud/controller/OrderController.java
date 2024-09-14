package com.atguigu.cloud.controller;

import com.atguigu.cloud.entities.PayDTO;
import com.atguigu.cloud.resp.ResultData;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@Tag(name = "订单微服务模块", description = "订单CRUD")
public class OrderController {
    public static final String Payment_URL="http://localhost:8001"; //先硬编码，后期再改成注册中心
    @Resource
    private RestTemplate restTemplate;

    @PostMapping("/consumer/pay/add")
    @Operation(summary = "新增",description = "新增订单方法")
    public ResultData addOrder(@RequestBody PayDTO payDTO) {
        return restTemplate.postForObject(Payment_URL + "/pay/add", payDTO, ResultData.class);
    }

    @GetMapping("/consumer/pay/get/{id}")
    @Operation(summary = "查询",description = "查询订单方法")
    public ResultData getPayInfo(@PathVariable("id") int id) {
        return restTemplate.getForObject(Payment_URL + "/pay/get/" + id, ResultData.class , id);
    }

    @GetMapping("/consumer/pay/del/{id}")
    @Operation(summary = "删除",description = "删除订单方法")
    public ResultData delPayInfo(@PathVariable("id") int id) {
        return restTemplate.getForObject(Payment_URL + "/pay/del/" + id, ResultData.class , id);
    }

    @GetMapping("/consumer/pay/getAll")
    @Operation(summary = "查询所有",description = "查询所有订单方法")
    public ResultData getAllPayInfo() {
        return restTemplate.getForObject(Payment_URL + "/pay/getAll", ResultData.class);
    }

    @PostMapping("/consumer/pay/update")
    @Operation(summary = "更新",description = "更新订单方法")
    public ResultData updatePayInfo(@RequestBody PayDTO payDTO) {
        return restTemplate.postForObject(Payment_URL + "/pay/update", payDTO, ResultData.class);
    }
}
