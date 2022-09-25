package com.order.springboottesttransaction.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.order.springboottesttransaction.entity.OrderDetail;
import com.order.springboottesttransaction.service.OrderDetailService;
import com.order.springboottesttransaction.mapper.OrderDetailMapper;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【order_detail】的数据库操作Service实现
* @createDate 2022-09-25 18:07:55
*/
@Service
public class OrderDetailServiceImpl extends ServiceImpl<OrderDetailMapper, OrderDetail>
    implements OrderDetailService{

}




