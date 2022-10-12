package com.fs.tulingsql.service;

import com.fs.tulingsql.dto.ProductDetailDTO;
import com.fs.tulingsql.entity.PmsProduct;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author Administrator
* @description 针对表【pms_product(商品信息)】的数据库操作Service
* @createDate 2022-10-12 13:14:23
*/
public interface PmsProductService extends IService<PmsProduct> {

    /**
     * 取商品详情获
     * @param id 商品id
     * @return
     */
    ProductDetailDTO getProductDetail(Long id);
}
