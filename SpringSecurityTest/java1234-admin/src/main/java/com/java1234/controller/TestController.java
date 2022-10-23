package com.java1234.controller;

import com.java1234.entity.R;
import com.java1234.entity.SysUserRole;
import com.java1234.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author java1234_小锋 （公众号：java1234）
 * @site www.java1234.vip
 * @company 南通小锋网络科技有限公司
 */
@RestController
public class TestController {

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private SysUserService sysUserService;

    @PreAuthorize("hasRole('admin')")
    @GetMapping("/test")
    public R test(){
        return R.ok("测试成功");
    }

    @GetMapping("/password")
    public R password(){
        String password = bCryptPasswordEncoder.encode("123456");
        System.out.println("password:"+password);
        return R.ok();
    }

    @PreAuthorize("hasAnyAuthority('system:user:list')")
    @GetMapping("/user/list")
    public R userList(){
        Map<String,Object> userList=new HashMap<String,Object>();
        userList.put("userList",sysUserService.list());
        return R.ok(userList);
    }



}
