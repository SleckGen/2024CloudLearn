package com.atguigu.cloud.controller;

import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import com.atguigu.cloud.entities.Pay;
import com.atguigu.cloud.entities.PayDTO;
import com.atguigu.cloud.resp.ResultData;
import com.atguigu.cloud.resp.ReturnCodeEnum;
import com.atguigu.cloud.service.PayService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.xml.transform.Result;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
@Tag(name = "支付微服务模块", description = "支付CRUD")
public class PayController {
    @Resource
    private PayService payService;



    @PostMapping(value = "/pay/add")
    @Operation(summary = "新增",description = "新增支付流水方法,json串做参数")
    public ResultData<String> addPay(@RequestBody Pay pay)
    {
        System.out.println(pay.toString());
        int i = payService.add(pay);
        return ResultData.success("成功插入记录，返回值："+i);
    }

    @GetMapping(value = "/pay/del/{id}")
    @Operation(summary = "删除支付信息", description = "删除支付流水方法")
    public ResultData<String> delete(@PathVariable("id") Integer id) {
        log.info("删除支付信息：" + id);
        int delete = payService.delete(id);
        return ResultData.success("成功删除支付记录，返回值:" + delete);
    }

    // 更新
    @PostMapping(value = "/pay/update")
    @Operation(summary = "更新支付信息", description = "修改支付流水方法")
    public ResultData<String> update(@RequestBody PayDTO payDTO) {
        log.info("更新支付信息：" + payDTO);

        Pay pay = new Pay();
        BeanUtils.copyProperties(payDTO, pay);
        int update = payService.update(pay);

        return ResultData.success("成功更新支付记录，返回值:" + update);
    }

    // 查询根据id
    @GetMapping(value = "/pay/get/{id}")
    @Operation(summary = "查询支付信息", description = "查询支付信息")
    public ResultData<PayDTO> getById(@PathVariable("id") Integer id) {
        log.info("查询支付信息：" + id);

        Pay pay = payService.getById(id);
        PayDTO payDTO = new PayDTO();
        BeanUtils.copyProperties(pay, payDTO);

        return ResultData.success(payDTO);
    }

    @GetMapping(value = "/pay/getAll")
    @Operation(summary = "查询所有支付信息", description = "查询所有支付信息")
    public ResultData<List<PayDTO>> getAll() {
        log.info("查询所有支付信息");

        List<Pay> all = payService.getAll();
        List<PayDTO> allDTO = all.stream().map(pay -> {
            PayDTO DTO = new PayDTO();
            BeanUtils.copyProperties(pay, DTO);
            return DTO;
        }).toList();

        return ResultData.success(allDTO);
    }


    @GetMapping(value = "/pay/error")
    public ResultData<Integer> getPayError() {
        Integer integer = Integer.valueOf(200);

        try{
            System.out.println("came in payerror test");
            int hash = 10 / 0;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultData.fail(ReturnCodeEnum.RC500.getCode(), e.getMessage());
        }
        return ResultData.success(integer);
    }

    @Value("${server.port}")
    private String port;

    @GetMapping(value = "/pay/get/info")
    public String getInfoByConsul(@Value("${atguigu.info}") String atguiguInfo) {
        try{
            TimeUnit.SECONDS.sleep(10);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "atguigu:" + atguiguInfo + "\t" + " port: " + port;
    }

}
