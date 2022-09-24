package com.test.mybatisx.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName biz_course
 */
@TableName(value ="biz_course")
@Data
public class BizCourse implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 
     */
    private String courseno;

    /**
     * 
     */
    private String coursename;

    /**
     * 
     */
    private Date createtime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}