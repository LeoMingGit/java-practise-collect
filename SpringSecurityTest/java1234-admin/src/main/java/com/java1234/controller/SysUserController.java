package com.java1234.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.java1234.common.constant.Constant;
import com.java1234.entity.*;
import com.java1234.service.SysRoleService;
import com.java1234.service.SysUserRoleService;
import com.java1234.service.SysUserService;
import com.java1234.util.DateUtil;
import com.java1234.util.RedisUtil;
import com.java1234.util.StringUtil;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.security.Principal;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 用户Controller控制器
 * @author java1234_小锋 （公众号：java1234）
 * @site www.java1234.vip
 * @company 南通小锋网络科技有限公司
 */
@RestController
@RequestMapping("/sys/user")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SysRoleService sysRoleService;

    @Autowired
    private SysUserRoleService sysUserRoleService;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private RedisUtil redisUtil;

    @Value("${avatarImagesFilePath}")
    private String avatarImagesFilePath;

    @GetMapping("/info")
    @PreAuthorize("hasAuthority('system:user:query')")
    public R userInfo(Principal principal){
        Map<String,Object> resultMap=new HashMap<>();
        SysUser currentUser = sysUserService.getByUserName(principal.getName());
        resultMap.put("currentUser",currentUser);
        return R.ok(resultMap);
    }

    /**
     * 验证用户名
     * @param sysUser
     * @return
     */
    @PostMapping("/checkUserName")
    @PreAuthorize("hasAuthority('system:user:query')")
    public R checkUserName(@RequestBody SysUser sysUser){
        if(sysUserService.getByUserName(sysUser.getUsername())==null){
            return R.ok();
        }else{
            return R.error();
        }
    }

    @PostMapping("/list")
    @PreAuthorize("hasAuthority('system:user:query')")
    public R list(@RequestBody PageBean pageBean){
        System.out.println("pageBean:"+pageBean);
        String query=pageBean.getQuery().trim();
        Page<SysUser> pageResult = sysUserService.page(new Page<>(pageBean.getPageNum(),pageBean.getPageSize()), new QueryWrapper<SysUser>().like(StringUtil.isNotEmpty(query), "username", query));
        List<SysUser> userList = pageResult.getRecords();
        for(SysUser user:userList){
            // 获取角色
            List<SysRole> roleList = sysRoleService.list(new QueryWrapper<SysRole>().inSql("id", "select role_id from sys_user_role where user_id=" + user.getId()));
            // 设置角色
            // user.setRoles(roleList.stream().map(SysRole::getName).collect(Collectors.joining(",")));
            user.setSysRoleList(roleList);
        }
        Map<String,Object> resultMap=new HashMap<>();
        resultMap.put("userList",userList);
        resultMap.put("total",pageResult.getTotal());
        return R.ok(resultMap);
    }

    /**
     * 添加或者修改
     * @param sysUser
     * @return
     */
    @PostMapping("/save")
    @PreAuthorize("hasAuthority('system:user:add')"+"||"+"hasAuthority('system:user:edit')")
    public R save(@RequestBody @Valid SysUser sysUser){
        if(sysUser.getId()==null || sysUser.getId()==-1){
            sysUser.setCreateTime(new Date());
            sysUser.setPassword(bCryptPasswordEncoder.encode(sysUser.getPassword()));
            sysUserService.save(sysUser);
        }else{
            sysUser.setUpdateTime(new Date());
            sysUserService.updateById(sysUser);
        }
        return R.ok();
    }

    /**
     * 修改密码
     * @param sysUser
     * @return
     */
    @PostMapping("/updateUserPwd")
    @PreAuthorize("hasAuthority('system:user:edit')")
    public R updateUserPwd(@RequestBody SysUser sysUser){
        SysUser currentUser = sysUserService.getById(sysUser.getId());
        currentUser.setPassword(bCryptPasswordEncoder.encode(sysUser.getNewPassword()));
        sysUserService.updateById(currentUser);
        return R.ok();
    }

    /**
     * 更新status状态
     * @param id
     * @param status
     * @return
     */
    @GetMapping("/updateStatus/{id}/status/{status}")
    @PreAuthorize("hasAuthority('system:user:edit')")
    public R updateStatus(@PathVariable(value = "id")Integer id,@PathVariable(value = "status")String status){
        SysUser sysUser = sysUserService.getById(id);
        sysUser.setStatus(status);
        sysUserService.saveOrUpdate(sysUser);
        redisUtil.removeByPrex(Constant.AUTHORITY_KEY);
        return R.ok();
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('system:user:query')")
    public R findById(@PathVariable(value = "id")Integer id){
        SysUser sysUser = sysUserService.getById(id);
        Map<String,Object> map=new HashMap<>();
        map.put("sysUser",sysUser);
        return R.ok(map);
    }

    /**
     * 重置密码
     * @param id
     * @return
     */
    @GetMapping("/resetPassword/{id}")
    @PreAuthorize("hasAuthority('system:user:edit')")
    public R resetPassword(@PathVariable(value = "id")Integer id){
        SysUser sysUser = sysUserService.getById(id);
        sysUser.setPassword(bCryptPasswordEncoder.encode(Constant.DEFAULT_PASSWORD));
        sysUser.setUpdateTime(new Date());
        sysUserService.updateById(sysUser);
        return R.ok();
    }


    /**
     * 修改用户头像
     * @param sysUser
     * @return
     */
    @RequestMapping("/updateAvatar")
    @PreAuthorize("hasAuthority('system:user:edit')")
    public R updateAvatar(@RequestBody SysUser sysUser){
        SysUser currentUser = sysUserService.getById(sysUser.getId());
        currentUser.setAvatar(sysUser.getAvatar());
        sysUserService.updateById(currentUser);
        return R.ok();
    }

    /**
     * 上传用户头像图片
     * @param file
     * @return
     * @throws Exception
     */
    @RequestMapping("/uploadImage")
    @PreAuthorize("hasAuthority('system:user:edit')")
    public Map<String,Object> uploadImage(MultipartFile file)throws Exception{
        Map<String,Object> resultMap=new HashMap<>();
        if(!file.isEmpty()){
            // 获取文件名
            String originalFilename = file.getOriginalFilename();
            String suffixName=originalFilename.substring(originalFilename.lastIndexOf("."));
            String newFileName= DateUtil.getCurrentDateStr()+suffixName;
            FileUtils.copyInputStreamToFile(file.getInputStream(),new File(avatarImagesFilePath+newFileName));
            resultMap.put("code",0);
            resultMap.put("msg","上传成功");
            Map<String,Object> dataMap=new HashMap<>();
            dataMap.put("title",newFileName);
            dataMap.put("src","image/userAvatar/"+newFileName);
            resultMap.put("data",dataMap);
        }
        return resultMap;
    }

    /**
     * 删除
     * @param ids
     * @return
     */
    @Transactional
    @PostMapping("/delete")
    @PreAuthorize("hasAuthority('system:user:delete')")
    public R delete(@RequestBody Long[] ids){
        sysUserService.removeByIds(Arrays.asList(ids));
        sysUserRoleService.remove(new QueryWrapper<SysUserRole>().in("user_id",ids));
        redisUtil.removeByPrex(Constant.AUTHORITY_KEY);
        return R.ok();
    }

    /**
     * 用户角色授权
     * @param userId
     * @param roleIds
     * @return
     */
    @Transactional
    @PostMapping("/grantRole/{userId}")
    @PreAuthorize("hasAuthority('system:user:role')")
    public R grantRole(@PathVariable("userId") Long userId,@RequestBody Long[] roleIds){
        List<SysUserRole> userRoleList=new ArrayList<>();
        Arrays.stream(roleIds).forEach(r -> {
            SysUserRole sysUserRole = new SysUserRole();
            sysUserRole.setRoleId(r);
            sysUserRole.setUserId(userId);
            userRoleList.add(sysUserRole);
        });
        sysUserRoleService.remove(new QueryWrapper<SysUserRole>().eq("user_id",userId));
        sysUserRoleService.saveBatch(userRoleList);
        redisUtil.removeByPrex(Constant.AUTHORITY_KEY);
        return R.ok();
    }


}
