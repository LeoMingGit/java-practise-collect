package com.java1234.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.java1234.common.constant.Constant;
import com.java1234.entity.R;
import com.java1234.entity.SysMenu;
import com.java1234.entity.SysRole;
import com.java1234.entity.SysUser;
import com.java1234.service.SysMenuService;
import com.java1234.service.SysRoleService;
import com.java1234.service.SysUserService;
import com.java1234.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.*;

/**
 * 系统菜单Controller控制器
 * @author java1234_小锋 （公众号：java1234）
 * @site www.java1234.vip
 * @company 南通小锋网络科技有限公司
 */
@RestController
@RequestMapping("/sys/menu")
public class SysMenuController {

    @Autowired
    private SysMenuService sysMenuService;

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SysRoleService sysRoleService;

    @Autowired
    private RedisUtil redisUtil;


    /**
     * 获取当前用户的导航菜单
     * @return
     */
//    @GetMapping("/navMenuList")
//    public R navMenuList(Principal principal){
//        Map<String,Object> resultMap=new HashMap<>();
//        SysUser currentUser = sysUserService.getByUserName(principal.getName());
//
//        // 获取当前用户拥有的权限菜单
//        // 获取角色
//        List<SysRole> roleList = sysRoleService.list(new QueryWrapper<SysRole>().inSql("id", "select role_id from sys_user_role where user_id=" + currentUser.getId()));
//
//        // 获取菜单权限
//        Set<SysMenu> menuSet = new HashSet<SysMenu>();
//        for(SysRole sysRole:roleList){
//            List<SysMenu> sysMenuList = sysMenuService.list(new QueryWrapper<SysMenu>().inSql("id", "select menu_id from sys_role_menu where role_id=" + sysRole.getId()));
//            for(SysMenu sysMenu:sysMenuList){
//                menuSet.add(sysMenu);
//            }
//        }
//
//        List<SysMenu> sysMenuList = new ArrayList<>(menuSet); // 转成集合List
//
//        sysMenuList.sort(Comparator.comparing(SysMenu::getOrderNum));  // 排序
//
//        List<SysMenu> navMenuList = buildTreeMenu(sysMenuList); // 构造菜单树
//
//        resultMap.put("navMenuList",navMenuList);
//
//        return R.ok(resultMap);
//    }

    @RequestMapping("/list")
    @PreAuthorize("hasAuthority('system:menu:query')")
    public R list(){
        // 查询所有菜单信息
        List<SysMenu> menuList=sysMenuService.list(new QueryWrapper<SysMenu>().orderByAsc("order_num"));
        return R.ok().put("treeMenu",sysMenuService.buildTreeMenu(menuList));
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('system:menu:query')")
    public R findById(@PathVariable(value = "id")Long id){
        SysMenu sysMenu = sysMenuService.getById(id);
        Map<String,Object> map=new HashMap<>();
        map.put("sysMenu",sysMenu);
        return R.ok(map);
    }

    /**
     * 添加或者修改
     * @param sysMenu
     * @return
     */
    @PostMapping("/save")
    @PreAuthorize("hasAuthority('system:menu:add')"+"||"+"hasAuthority('system:menu:edit')")
    public R save(@RequestBody @Valid SysMenu sysMenu){
        if(sysMenu.getId()==null || sysMenu.getId()==-1){
            sysMenu.setCreateTime(new Date());
            sysMenuService.save(sysMenu);
        }else{
            sysMenu.setUpdateTime(new Date());
            sysMenuService.updateById(sysMenu);
        }
        redisUtil.removeByPrex(Constant.AUTHORITY_KEY);
        return R.ok();
    }



    /**
     * 删除
     * @param id
     * @return
     */
    @GetMapping("/delete/{id}")
    @PreAuthorize("hasAuthority('system:menu:delete')")
    public R delete(@PathVariable(value = "id")Long id){
        int count = sysMenuService.count(new QueryWrapper<SysMenu>().eq("parent_id", id));
        if(count>0){
            return R.error("请先删除子菜单！");
        }
        sysMenuService.removeById(id);
        redisUtil.removeByPrex(Constant.AUTHORITY_KEY);
        return R.ok();
    }




//
//
//    /**
//     * 构造菜单树
//     * @param menuSet
//     * @return
//     */
//    private List<SysMenu> buildTreeMenu(List<SysMenu> menuSet){
//        List<SysMenu> resultMenuList = new ArrayList<>();
//
//        for (SysMenu sysMenu : menuSet) {
//            // 寻找子节点
//            for (SysMenu e : menuSet) {
//                if (e.getParentId()==sysMenu.getId()) {
//                    sysMenu.getChildren().add(e);
//                }
//            }
//            // 判断父节点，添加到集合
//            if(sysMenu.getParentId()==0L){
//                resultMenuList.add(sysMenu);
//            }
//        }
//        return resultMenuList;
//    }


}
