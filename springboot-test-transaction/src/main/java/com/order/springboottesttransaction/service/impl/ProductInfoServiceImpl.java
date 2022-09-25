package com.order.springboottesttransaction.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.order.springboottesttransaction.entity.ProductInfo;
import com.order.springboottesttransaction.service.ProductInfoService;
import com.order.springboottesttransaction.mapper.ProductInfoMapper;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【product_info】的数据库操作Service实现
* @createDate 2022-09-25 18:16:04
*/
@Service
public class ProductInfoServiceImpl extends ServiceImpl<ProductInfoMapper, ProductInfo>
    implements ProductInfoService{

}




