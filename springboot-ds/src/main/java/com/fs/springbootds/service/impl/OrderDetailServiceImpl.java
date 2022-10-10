package com.fs.springbootds.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fs.springbootds.domain.OrderDetail;
import com.fs.springbootds.service.OrderDetailService;
import com.fs.springbootds.mapper.OrderDetailMapper;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【order_detail】的数据库操作Service实现
* @createDate 2022-10-10 12:51:10
*/
@Service
public class OrderDetailServiceImpl extends ServiceImpl<OrderDetailMapper, OrderDetail>
    implements OrderDetailService{

}




