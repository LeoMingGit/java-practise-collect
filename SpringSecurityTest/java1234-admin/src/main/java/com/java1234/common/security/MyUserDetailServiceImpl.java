package com.java1234.common.security;

import com.java1234.common.exception.UserCountLockException;
import com.java1234.entity.SysUser;
import com.java1234.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

/**
 * @author java1234_小锋 （公众号：java1234）
 * @site www.java1234.vip
 * @company 南通小锋网络科技有限公司
 */
@Service
public class MyUserDetailServiceImpl implements UserDetailsService {

    @Autowired
    SysUserService sysUserService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser sysUser=sysUserService.getByUserName(username);
        if(sysUser==null){
            throw new UsernameNotFoundException("用户名不存在！");
        }else if("1".equals(sysUser.getStatus())){
            throw new UserCountLockException("该用户账号已被封禁，具体联系管理员！");
        }
        return new User(sysUser.getUsername(),sysUser.getPassword(),getUserAuthority(sysUser.getId()));
    }

    /**
     * 获取用户权限信息 包括角色 菜单权限信息
     * @param userId
     * @return
     */
    public List<GrantedAuthority> getUserAuthority(Long userId){
        System.out.println("xxxx");
        // 格式ROLE_admin,ROLE_common,system:user:resetPwd,system:role:delete,system:user:list,system:menu:query,system:menu:list,system:menu:add,system:user:delete,system:role:list,system:role:menu,system:user:edit,system:user:query,system:role:edit,system:user:add,system:user:role,system:menu:delete,system:role:add,system:role:query,system:menu:edit
        String authority=sysUserService.getUserAuthorityInfo(userId);
        System.out.println("authority="+authority);
        return AuthorityUtils.commaSeparatedStringToAuthorityList(authority);
    }
}
