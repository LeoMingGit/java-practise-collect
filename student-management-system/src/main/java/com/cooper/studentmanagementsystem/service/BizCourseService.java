package com.cooper.studentmanagementsystem.service;

import com.cooper.studentmanagementsystem.dto.saveCourseParam;
import com.cooper.studentmanagementsystem.dto.updateCourseParam;
import com.cooper.studentmanagementsystem.entity.BizCourse;
import com.baomidou.mybatisplus.extension.service.IService;
import io.swagger.models.auth.In;

import java.util.List;

/**
* @author Administrator
* @description 针对表【biz_course】的数据库操作Service
* @createDate 2022-09-24 19:21:26
*/
public interface BizCourseService extends IService<BizCourse> {

    List<BizCourse> findAllCourse();
    int  batchUpdateCreateTime(List<String> list);

    int SaveCourse(saveCourseParam param);

    boolean UpdateCourse(updateCourseParam param);

    boolean  deleteCourseByID(Integer id);
}
