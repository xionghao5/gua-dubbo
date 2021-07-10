package com.gua.guadubbointerface.pojo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Order {
    private String productName;
    private Integer mount;
    private BigDecimal price;
    private BigDecimal total;
}
