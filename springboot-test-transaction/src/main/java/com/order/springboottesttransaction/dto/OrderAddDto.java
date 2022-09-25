package com.order.springboottesttransaction.dto;

import com.order.springboottesttransaction.entity.OrderDetail;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class OrderAddDto {

    private String buyerName;

    private String buyerPhone;

    private List<OrderDetail> orderDetails;
}
