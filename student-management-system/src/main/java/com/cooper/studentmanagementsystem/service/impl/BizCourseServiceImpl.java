package com.cooper.studentmanagementsystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cooper.studentmanagementsystem.dto.saveCourseParam;
import com.cooper.studentmanagementsystem.dto.updateCourseParam;
import com.cooper.studentmanagementsystem.entity.BizCourse;
import com.cooper.studentmanagementsystem.service.BizCourseService;
import com.cooper.studentmanagementsystem.mapper.BizCourseMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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
    @Override
    public  int SaveCourse(saveCourseParam param){
         int effect=0;
         BizCourse  model=new BizCourse();
         BeanUtils.copyProperties(param, model);
         model.setCreatetime(new Date());
         effect= bizCourseMapper.insert(model);
         return  effect;
    }
    @Override
    public boolean UpdateCourse(updateCourseParam param){
        BizCourse  model=new BizCourse();
        BeanUtils.copyProperties(param, model);
        QueryWrapper<BizCourse> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(BizCourse::getId,param.getId());
        boolean isok=update(model,wrapper);
        return  isok;
    }

    @Override
    public boolean  deleteCourseByID(Integer id){
        QueryWrapper<BizCourse> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(BizCourse::getId,id);
        int effect= bizCourseMapper.delete(wrapper);
        if(effect>0) return true;
        return false;
    }


}




