package com.fs.tulingsql.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fs.tulingsql.entity.PmsSkuStock;
import com.fs.tulingsql.service.PmsSkuStockService;
import com.fs.tulingsql.mapper.PmsSkuStockMapper;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【pms_sku_stock(sku的库存)】的数据库操作Service实现
* @createDate 2022-10-12 13:17:26
*/
@Service
public class PmsSkuStockServiceImpl extends ServiceImpl<PmsSkuStockMapper, PmsSkuStock>
    implements PmsSkuStockService{

}




