package com.cooper.studentmanagementsystem.controller;


import com.cooper.studentmanagementsystem.entity.BizCourse;
import com.cooper.studentmanagementsystem.service.BizCourseService;
import com.cooper.studentmanagementsystem.tools.JSONResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 *
 * 课程信息
 */
@RestController
public class CourseController {

    @Autowired
    BizCourseService bizCourseService;


    @ApiOperation("获取课程信息")
    @RequestMapping(value = "getCourserInfo",method = RequestMethod.GET)
    @ResponseBody
    public   JSONResult  GetCourseInfo(@RequestParam("limit") Integer limit,@RequestParam("page") Integer page){

        System.out.printf(String.valueOf(limit));
        List<BizCourse> info= bizCourseService.findAllCourse();
        Integer total=info.size();
        return JSONResult.ok(info,total);
    }

    @ApiOperation("批量表中的createtime字段")
    @RequestMapping(value = "/batchUpdateCreateTime",method = RequestMethod.POST)
    @ResponseBody
    public JSONResult batchUpdateCreateTime(@RequestBody List<String> list) {

        int effectrow= bizCourseService.batchUpdateCreateTime(list);
        if(effectrow>0){
            return JSONResult.ok("success");
        }
        return JSONResult.errorMsg("failure");
    }



}
