package com.atguigu.cloud.controller;

import com.atguigu.cloud.entities.PayDTO;
import com.atguigu.cloud.resp.ResultData;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@Tag(name = "订单微服务模块", description = "订单CRUD")
public class OrderController {
//    public static final String Payment_URL="http://localhost:8001"; //先硬编码，后期再改成注册中心
    public static final String Payment_URL="http://cloud-payment-service"; //服务注册中心上的微服务名称
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

    @GetMapping("/consumer/pay/get/info")
    public String getInfoConsul() {
        return restTemplate.getForObject(Payment_URL + "/pay/get/info", String.class);
    }
    @Resource
    private DiscoveryClient discoveryClient;
    @GetMapping("/consumer/discovery")
    public String discovery()
    {
        List<String> services = discoveryClient.getServices();
        for (String element : services) {
            System.out.println(element);
        }

        System.out.println("===================================");

        List<ServiceInstance> instances = discoveryClient.getInstances("cloud-payment-service");
        for (ServiceInstance element : instances) {
            System.out.println(element.getServiceId()+"\t"+element.getHost()+"\t"+element.getPort()+"\t"+element.getUri());
        }

        return instances.get(0).getServiceId()+":"+instances.get(0).getPort();
    }
}
