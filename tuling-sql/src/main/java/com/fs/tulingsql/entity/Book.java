package com.fs.tulingsql.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * @TableName book
 */
@TableName(value ="book")
@Data
public class Book implements Serializable {
    private Integer id;

    private Integer authorId;

    private String bookName;

    private String bookType;

    private static final long serialVersionUID = 1L;
}