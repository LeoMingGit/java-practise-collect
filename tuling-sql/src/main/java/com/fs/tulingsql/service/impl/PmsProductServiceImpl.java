package com.fs.tulingsql.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fs.tulingsql.entity.PmsProduct;
import com.fs.tulingsql.service.PmsProductService;
import com.fs.tulingsql.mapper.PmsProductMapper;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【pms_product(商品信息)】的数据库操作Service实现
* @createDate 2022-10-12 13:14:23
*/
@Service
public class PmsProductServiceImpl extends ServiceImpl<PmsProductMapper, PmsProduct>
    implements PmsProductService{

}




