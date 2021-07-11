package com.gua.dubbo.api.pojo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Order {

    private String productName;
    private BigDecimal price;
    private Integer mount;
    private BigDecimal total;

}
