package com.cooper.studentmanagementsystem.mapper;

import com.cooper.studentmanagementsystem.entity.BizCourse;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
* @author Administrator
* @description 针对表【biz_course】的数据库操作Mapper
* @createDate 2022-09-24 19:21:26
* @Entity com.cooper.studentmanagementsystem.entity.BizCourse
*/
public interface BizCourseMapper extends BaseMapper<BizCourse> {

    public List<BizCourse> findAllCourse() ;

    int  batchUpdateCreateTime(List<String> list);
}




