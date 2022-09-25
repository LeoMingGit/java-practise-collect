package com.order.springboottesttransaction.enums;


import lombok.Getter;

@Getter
public enum OrderStatusEnums {

    NO_PAY(0, "下单成功，未支付"),
    SUCCESS(1, "下单成功，已支付"),
    CANCEL(2, "取消订单");

    private int code;
    private String msg;

    OrderStatusEnums(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
