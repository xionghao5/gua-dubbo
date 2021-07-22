package com.gua.dubbo.api.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class Result implements Serializable {
    private String code;
    private String msg;
}
