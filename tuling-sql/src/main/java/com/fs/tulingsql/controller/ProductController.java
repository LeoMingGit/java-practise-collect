package com.fs.tulingsql.controller;

import com.fs.tulingsql.dto.ProductDetailDTO;
import com.fs.tulingsql.mapper.PmsProductMapper;
import com.fs.tulingsql.service.PmsProductService;
import com.fs.tulingsql.utility.CommonResult;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/***
 *
 */
@RestController
@Api(tags = "ProductController",description = "商品详情服务接口")
@RequestMapping("/product")
public class ProductController {

    @Autowired
    PmsProductService productService;

    /**
     *  取商品详情获
     * .get(`/product/detail/${this.id}`)
     */
    @RequestMapping(value = "/detail/{id}",method = RequestMethod.GET)
    public CommonResult getProductDetail(@PathVariable Long id){
        ProductDetailDTO productDetailDTO= productService.getProductDetail(id);
        return CommonResult.success(productDetailDTO);
    }
}
