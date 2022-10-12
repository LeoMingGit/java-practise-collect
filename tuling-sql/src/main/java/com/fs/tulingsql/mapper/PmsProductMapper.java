package com.fs.tulingsql.mapper;

import com.fs.tulingsql.dto.ProductDetailDTO;
import com.fs.tulingsql.entity.PmsProduct;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author Administrator
* @description 针对表【pms_product(商品信息)】的数据库操作Mapper
* @createDate 2022-10-12 13:14:23
* @Entity com.fs.tulingsql.entity.PmsProduct
*/
public interface PmsProductMapper extends BaseMapper<PmsProduct> {

    ProductDetailDTO getProductDetail(Long id);

}




