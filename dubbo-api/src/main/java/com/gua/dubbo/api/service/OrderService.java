package com.gua.dubbo.api.service;

import com.gua.dubbo.api.pojo.Order;
import com.gua.dubbo.api.pojo.Result;

public interface OrderService {
    Result buy(Order order);
}
