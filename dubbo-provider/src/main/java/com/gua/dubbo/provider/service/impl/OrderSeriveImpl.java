package com.gua.dubbo.provider.service.impl;

import com.gua.dubbo.api.pojo.Order;
import com.gua.dubbo.api.pojo.Result;
import com.gua.dubbo.api.service.OrderService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Service;

@Service
@DubboService(version = "${service.version}")
public class OrderSeriveImpl implements OrderService {
    @Override
    public Result buy(Order order) {
        Result result = new Result();
        if (order.getProductName().equals("fuck")) {
            result.setCode("1");
            result.setMsg("success");
        } else {
            result.setCode("-1");
            result.setMsg("fail");
        }
        return result;
    }
}
