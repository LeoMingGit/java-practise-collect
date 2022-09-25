package com.order.springboottesttransaction.dto;

import com.alibaba.fastjson.JSON;
import com.order.springboottesttransaction.entity.OrderDetail;
import com.order.springboottesttransaction.vo.OrderAddVo;

import java.util.List;

public class ConvertOrderAddVo2OrderAddDto {
    public static OrderAddDto convert(OrderAddVo orderAddVo) {
        OrderAddDto orderAddDto = new OrderAddDto();

        List<OrderDetail> orderDetails = JSON.parseArray(orderAddVo.getOrderDetails(), OrderDetail.class);

        orderAddDto.setBuyerName(orderAddVo.getBuyerName())
                .setBuyerPhone(orderAddVo.getBuyerPhone())
                .setOrderDetails(orderDetails);
        return orderAddDto;
    }
}
