package com.mybatisplus.mybatisplus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mybatisplus.mybatisplus.model.Student;
import com.mybatisplus.mybatisplus.service.StudentService;
import com.mybatisplus.mybatisplus.mapper.StudentMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
* @author 李响
* @description 针对表【student】的数据库操作Service实现
* @createDate 2023-05-07 16:19:55
*/
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student>
    implements StudentService{

    @Resource
    private   StudentMapper  studentMapper;
    @Override
    public List QueryAllStudent(){
       List<Student> students= studentMapper.selectList(null);
       return  students;
    }
}




