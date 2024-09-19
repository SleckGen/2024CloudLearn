package com.atguigu.cloud.apis;

import com.atguigu.cloud.entities.PayDTO;
import com.atguigu.cloud.resp.ResultData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "cloud-payment-service")
public interface PayFeignApi {
    /*
    * 新增一条支付相关流水记录
    * */
    @PostMapping("/pay/add")
    public ResultData addPay(@RequestBody PayDTO payDTO);

    /*
    *  按照主键查询支付流水信息
    * */
    @GetMapping("/pay/get/{id}")
    public ResultData getPayInfo(@PathVariable("id") Integer id);

    /*
    * openfeign天然支持负载均衡演示
    * */
    @GetMapping("/pay/get/info")
    public String mylb();

    /*
     * Resilience4j 之前的演示
     * 熔断演示
     * */
    @GetMapping(value = "/pay/circuit/{id}")
    public String myCircuit(@PathVariable("id") Integer id);
    /*
     * Bulkhead 的演示
     * */
    @GetMapping(value = "/pay/bulkhead/{id}")
    public String myBulkhead(@PathVariable("id") Integer id);
}
