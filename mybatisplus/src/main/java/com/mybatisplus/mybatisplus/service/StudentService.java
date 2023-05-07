package com.mybatisplus.mybatisplus.service;

import com.mybatisplus.mybatisplus.model.Student;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author 李响
* @description 针对表【student】的数据库操作Service
* @createDate 2023-05-07 16:19:55
*/
public interface StudentService extends IService<Student> {


    /**
     * 获取所有学生信息
     * @return
     */
    List QueryAllStudent() ;

}
