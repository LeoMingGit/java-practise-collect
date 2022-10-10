package com.fs.springbootds.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fs.springbootds.domain.OrderMaster;
import com.fs.springbootds.service.OrderMasterService;
import com.fs.springbootds.mapper.OrderMasterMapper;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【order_master】的数据库操作Service实现
* @createDate 2022-10-10 12:52:11
*/
@Service
public class OrderMasterServiceImpl extends ServiceImpl<OrderMasterMapper, OrderMaster>
    implements OrderMasterService{

}




