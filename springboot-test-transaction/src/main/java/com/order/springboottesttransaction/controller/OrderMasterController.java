package com.order.springboottesttransaction.controller;

import com.order.springboottesttransaction.dto.ConvertOrderAddVo2OrderAddDto;
import com.order.springboottesttransaction.dto.OrderAddDto;
import com.order.springboottesttransaction.service.OrderMasterService;
import com.order.springboottesttransaction.vo.OrderAddVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order/order-master")
public class OrderMasterController {
    @Autowired
    OrderMasterService orderMasterService;

    @PostMapping("/create")
    public int create(@RequestBody  OrderAddVo orderAddVo) {
        OrderAddDto orderAddDto = ConvertOrderAddVo2OrderAddDto.convert(orderAddVo);
        return orderMasterService.createOrder(orderAddDto);
    }
}
