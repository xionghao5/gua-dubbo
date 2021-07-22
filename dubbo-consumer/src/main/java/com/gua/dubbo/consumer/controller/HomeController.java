package com.gua.dubbo.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.gua.dubbo.api.pojo.Order;
import com.gua.dubbo.api.pojo.Result;
import com.gua.dubbo.api.service.OrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @Reference
    private OrderService orderService;

    @PostMapping("/buy")
    public Result buy(@RequestBody Order order){
        Result result = orderService.buy(order);
        return result;
    }
}
