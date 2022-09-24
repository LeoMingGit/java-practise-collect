package com.cooper.studentmanagementsystem.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cooper.studentmanagementsystem.entity.BizCourse;
import com.cooper.studentmanagementsystem.service.BizCourseService;
import com.cooper.studentmanagementsystem.mapper.BizCourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author Administrator
* @description 针对表【biz_course】的数据库操作Service实现
* @createDate 2022-09-24 19:21:26
*/
@Service
public class BizCourseServiceImpl extends ServiceImpl<BizCourseMapper, BizCourse>
    implements BizCourseService{

    @Autowired
    BizCourseMapper bizCourseMapper;

    @Override
    public List<BizCourse> findAllCourse() {
        List<BizCourse> info  =bizCourseMapper.findAllCourse();
        return   info;
    }

    @Override
    public int  batchUpdateCreateTime(List<String> list){
        int effectrow=bizCourseMapper.batchUpdateCreateTime(list);
        return effectrow;
    }

}




