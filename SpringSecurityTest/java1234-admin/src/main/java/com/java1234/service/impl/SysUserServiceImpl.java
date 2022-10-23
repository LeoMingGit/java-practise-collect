package com.java1234.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.java1234.common.constant.Constant;
import com.java1234.entity.SysMenu;
import com.java1234.entity.SysRole;
import com.java1234.entity.SysUser;
import com.java1234.mapper.SysMenuMapper;
import com.java1234.mapper.SysRoleMapper;
import com.java1234.service.SysUserService;
import com.java1234.mapper.SysUserMapper;
import com.java1234.util.RedisUtil;
import com.java1234.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
* @author java1234
* @description 针对表【sys_user】的数据库操作Service实现
* @createDate 2022-06-22 08:45:09
*/
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser>
    implements SysUserService{

    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private SysMenuMapper sysMenuMapper;

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public SysUser getByUserName(String username) {
        return getOne(new QueryWrapper<SysUser>().eq("username",username));
    }

    @Override
    public String getUserAuthorityInfo(Long userId) {
        StringBuffer authority=new StringBuffer();

        if(redisUtil.hasKey(Constant.AUTHORITY_KEY+userId)){
            System.out.println("有缓存");
            authority.append(redisUtil.get(Constant.AUTHORITY_KEY,String.valueOf(userId)));
        }else{
            System.out.println("没缓存");
            // 获取角色
            List<SysRole> roleList = sysRoleMapper.selectList(new QueryWrapper<SysRole>().inSql("id", "select role_id from sys_user_role where user_id=" + userId));

            if(roleList.size()>0){
                String roleCodeStrs=roleList.stream().map(r->"ROLE_"+r.getCode()).collect(Collectors.joining(","));
                authority.append(roleCodeStrs);
            }

            // 获取菜单权限
            Set<String> menuCodeSet = new HashSet<String>();
            for(SysRole sysRole:roleList){
                List<SysMenu> sysMenuList = sysMenuMapper.selectList(new QueryWrapper<SysMenu>().inSql("id", "select menu_id from sys_role_menu where role_id=" + sysRole.getId()));
                for(SysMenu sysMenu:sysMenuList){
                    String perms=sysMenu.getPerms();
                    if(StringUtil.isNotEmpty(perms)){
                        menuCodeSet.add(perms);
                    }
                }
            }
            if(menuCodeSet.size()>0){
                authority.append(",");
                String menuCodeStrs = menuCodeSet.stream().collect(Collectors.joining(","));
                authority.append(menuCodeStrs);
            }
            redisUtil.set(Constant.AUTHORITY_KEY,String.valueOf(userId),authority,10*60);
            System.out.println("authority:"+authority.toString());
        }
        return authority.toString();
    }
}




