package com.atguigu.cloud.controller;

import com.atguigu.cloud.service.FlowLimitService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
public class FlowLimitController
{

    @Resource
    private FlowLimitService flowLimitService;
    @GetMapping("/testA")
    public String testA()
    {
        return "------testA";
    }

    @GetMapping("/testB")
    public String testB()
    {
        return "------testB";
    }

    /**流控-链路演示demo
     * C和D两个请求都访问flowLimitService.common()方法，阈值到达后对C限流，对D不管
     */
    @GetMapping("/testC")
    public String testC()
    {
        flowLimitService.common();
        return "------testC";
    }

    @GetMapping("/testD")
    public String testD()
    {
        flowLimitService.common();
        return "------testD";
    }

    @GetMapping("/testE")
    public String testE()
    {
        System.out.println(System.currentTimeMillis() + "------testE");
        return "------testE";
    }

    /*
     * 新增熔断规则-慢调用比例
     * */
    @GetMapping("/testF")
    public String testF()
    {
        //暂停几秒钟线程
        try{
            TimeUnit.SECONDS.sleep(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("------测试：新增熔断规则-慢调用比例 ");
        return "------testF 新增熔断规则-慢调用比例";
    }


    /*
     * 新增熔断规则-异常比例
     * */
    @GetMapping("/testG")
    public String testG()
    {
        System.out.println("------测试：新增熔断规则-异常比例 ");
        int age = 10/0;
        return "------testF 新增熔断规则-异常比例";
    }

    /*
    * 新增熔断规则-异常数
    * */
    @GetMapping("/testH")
    public String testH()
    {
        System.out.println("------测试：新增熔断规则-异常比例 ");
        int age = 10/0;
        return "------testF 新增熔断规则-异常比例";
    }
}



