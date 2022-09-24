package com.cooper.studentmanagementsystem.service;

import com.cooper.studentmanagementsystem.entity.BizCourse;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author Administrator
* @description 针对表【biz_course】的数据库操作Service
* @createDate 2022-09-24 19:21:26
*/
public interface BizCourseService extends IService<BizCourse> {

    List<BizCourse> findAllCourse();
    int  batchUpdateCreateTime(List<String> list);

}
