package cn.edu.sdut.mapper;

import cn.edu.sdut.entity.Tbuser;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    Tbuser queryUserById(int userid);
    int queryUserCount();
    Tbuser queryUserByusername(String username);
    Tbuser login(Tbuser tbuser);
    List<Tbuser> queryUsers(Tbuser tbuser);
    int addUser(Tbuser tbuser);
    int updateUser(Tbuser tbuser);
    int deleteUser(int userid);
    //全选删除
    int deleteUsers(@Param("ids") int ids[]);

    //多参数的解决方案
    //方案一
    Tbuser login1(String username,String password);
    //方案二
    Tbuser login2(@Param("uname") String username, @Param("pwd") String password);
    //方案三----map的key要和#{}一一对应，例如key是“uname”,#{uname}
    Tbuser login3(Map<String,Object> map);
    /**方案四----官方推荐我们尽量把多个参数封装在一个JavaBean(entity,pojo,vo,domain),这个
     * javaBean被@Param修饰
     */
    Tbuser login4(@Param("user") Tbuser tbuser);


}
