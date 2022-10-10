package com.fs.springbootds.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fs.springbootds.domain.ProductInfo;
import com.fs.springbootds.service.ProductInfoService;
import com.fs.springbootds.mapper.ProductInfoMapper;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【product_info】的数据库操作Service实现
* @createDate 2022-10-10 12:52:19
*/
@Service
public class ProductInfoServiceImpl extends ServiceImpl<ProductInfoMapper, ProductInfo>
    implements ProductInfoService{

}




