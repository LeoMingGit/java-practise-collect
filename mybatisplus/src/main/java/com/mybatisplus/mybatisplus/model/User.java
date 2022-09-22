package com.mybatisplus.mybatisplus.model;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.sun.org.apache.xpath.internal.objects.XString;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.IdType;

import java.io.Serializable;


@Data
@TableName("user")
public class User implements Serializable {

    @TableId(value = "test_id", type = IdType.AUTO)
    private Long test_id;

    private Long tenant_id;

    private String name;

    private  Integer age;

    private  Integer test_type;

    private  long  role;

    private  String phone;

}