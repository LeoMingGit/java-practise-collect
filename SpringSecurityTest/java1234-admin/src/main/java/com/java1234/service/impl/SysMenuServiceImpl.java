package com.java1234.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.java1234.entity.SysMenu;
import com.java1234.service.SysMenuService;
import com.java1234.mapper.SysMenuMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
* @author java1234
* @description 针对表【sys_menu】的数据库操作Service实现
* @createDate 2022-07-05 08:48:37
*/
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu>
    implements SysMenuService{


    /**
     * 构造菜单树
     * @param sysMenuList
     * @return
     */
     public List<SysMenu> buildTreeMenu(List<SysMenu> sysMenuList){
        List<SysMenu> resultMenuList = new ArrayList<>();

        for (SysMenu sysMenu : sysMenuList) {
            // 寻找子节点
            for (SysMenu e : sysMenuList) {
                if (e.getParentId()==sysMenu.getId()) {
                    sysMenu.getChildren().add(e);
                }
            }
            // 判断父节点，添加到集合
            if(sysMenu.getParentId()==0L){
                resultMenuList.add(sysMenu);
            }
        }
        return resultMenuList;
    }

}




