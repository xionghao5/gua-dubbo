package com.gua.dubbo.api.pojo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class Order implements Serializable {

    private String productName;
    private BigDecimal price;
    private Integer mount;
    private BigDecimal total;

}
