package com.java1234.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 公共基础实体类
 * @author java1234_小锋 （公众号：java1234）
 * @site www.java1234.vip
 * @company 南通小锋网络科技有限公司
 */
@Data
public class BaseEntity implements Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 创建日期
     */
    @JsonSerialize(using=CustomDateTimeSerializer.class)
    @JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /**
     * 更新日期
     */
    @JsonSerialize(using=CustomDateTimeSerializer.class)
    @JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    /**
     * 备注
     */
    private String remark;




}
