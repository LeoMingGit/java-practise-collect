package com.fs.tulingsql.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * @TableName pms_product_attribute_value
 */
@TableName(value ="pms_product_attribute_value")
@Data
public class PmsProductAttributeValue implements Serializable {
    private Long id;

    private Long productId;

    private Long productAttributeId;

    private String value;

    private static final long serialVersionUID = 1L;
}