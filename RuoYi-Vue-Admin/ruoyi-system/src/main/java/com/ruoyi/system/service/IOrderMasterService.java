package com.ruoyi.system.service;

import com.ruoyi.system.domain.OrderMaster;
import com.ruoyi.system.domain.dto.OrderQueryDTO;

import java.util.List;

public interface IOrderMasterService {
    // 根据订单主键查询订单
    OrderMaster selectOrderById(Integer orderId);

    // 创建订单
    int createOrder(OrderMaster order);

    // 更新订单信息
    int updateOrder(OrderMaster order);

    // 删除订单
    int deleteOrder(Integer orderId);

    List<OrderMaster> selectOrdersByPage(OrderQueryDTO queryDTO);

    long  countTotalOrder  (OrderQueryDTO queryDTO);

}
