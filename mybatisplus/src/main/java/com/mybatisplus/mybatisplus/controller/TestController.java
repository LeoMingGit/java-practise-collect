package com.mybatisplus.mybatisplus.controller;

import com.mybatisplus.mybatisplus.model.Student;
import com.mybatisplus.mybatisplus.service.StudentService;
import com.mybatisplus.mybatisplus.service.TeacherService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class TestController {
    @Autowired

    private StudentService studentService;

    @Autowired

    private TeacherService   teacherService;

    @ApiOperation("查询全部学习信息")
    @GetMapping("/student/queryall")
    public List QueryAllStudent() {

        List<Student> students = studentService.QueryAllStudent();
        System.out.println(students);
        return students;
    }



}
