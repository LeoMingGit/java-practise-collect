package com.mybatisplus.mybatisplus.controller;
import com.mybatisplus.mybatisplus.mapper.UserMapper;
import com.mybatisplus.mybatisplus.model.User;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.alibaba.fastjson.JSON;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserMapper userMapper;
    @ApiOperation("获取所有用户信息")
    @RequestMapping(value = "/GetAllUsers", method = RequestMethod.GET)
    @ResponseBody
    public String GetAllUsers() {
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userMapper.selectList(null);
        userList.forEach(System.out::println);

        String jsonString = JSON.toJSONString(userList);
        System.out.println(jsonString);
        return jsonString;
    }


}
