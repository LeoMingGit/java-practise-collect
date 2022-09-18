package com.restfull.restfullapi.controller;

import com.restfull.restfullapi.common.CommonResult;
import com.restfull.restfullapi.model.Role;
import com.restfull.restfullapi.service.impl.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import  com.restfull.restfullapi.common.CommonResult;
import java.util.List;
@RestController

public class UserManagerController {

    @Autowired
    private UserService   userService;

    @ApiOperation("获取户的角色")
    @RequestMapping(value = "/getRoleList", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<Role>> getRoleList() {
        List<Role> roleList = userService.GetRoleList();
        return CommonResult.success(roleList);
    }

}
