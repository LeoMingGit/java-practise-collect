package com.order.springboottesttransaction.service;

import com.order.springboottesttransaction.dto.OrderAddDto;
import com.order.springboottesttransaction.entity.OrderMaster;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author Administrator
* @description 针对表【order_master】的数据库操作Service
* @createDate 2022-09-25 18:06:32
*/
public interface OrderMasterService extends IService<OrderMaster> {
    // 新增订单
    public Integer createOrder(OrderAddDto orderAddDto);
}
