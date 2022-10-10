package com.fs.springbootds.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName order_detail
 */
@TableName(value ="order_detail")
@Data
public class OrderDetail implements Serializable {
    /**
     * 详情主键
     */
    @TableId(type = IdType.AUTO)
    private Integer detailId;

    /**
     * 订单主键
     */
    private Integer orderId;

    /**
     * 商品主键
     */
    private Integer productId;

    /**
     * 商品名称
     */
    private String productName;

    /**
     * 当前价格
     */
    private BigDecimal productPrice;

    /**
     * 数量
     */
    private Integer productNumber;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 创建人
     */
    private String createUser;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 修改人
     */
    private String updateUser;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}