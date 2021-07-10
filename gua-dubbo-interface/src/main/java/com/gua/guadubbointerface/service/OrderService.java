package com.gua.guadubbointerface.service;

import com.gua.guadubbointerface.pojo.Order;
import com.gua.guadubbointerface.pojo.Result;

public interface OrderService {
    Result buy(Order order);
}
