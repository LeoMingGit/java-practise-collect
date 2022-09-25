package com.order.springboottesttransaction.enums;
import lombok.Getter;

/**
 * 业务异常
 */
@Getter
public enum AppCode implements StatusCode {

    APP_ERROR(2000, "业务异常"),
    PRICE_ERROR(2001, "价格异常"),
    PRODUCT_NOT_EXIST(2002, "商品不存在"),
    ORDER_NOT_EXIST(2003, "订单不存在"),
    ORDER_DETAILS_NOT_EXIST(2004, "订单详情不存在");

    private int code;
    private String msg;

    AppCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
