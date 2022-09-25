package com.order.springboottesttransaction.enums;

import lombok.Getter;

@Getter
public enum ProductStatusEnums {
    UP(0, "上架"),
    DOWN(1, "下架");

    private int code;
    private String msg;

    ProductStatusEnums(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
