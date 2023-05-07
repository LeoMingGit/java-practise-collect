package cn.edu.sdut.test.user;

import cn.edu.sdut.entity.Tbuser;
import cn.edu.sdut.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestUser {
     private String mybatisconfig="mybatis.xml";

     private SqlSessionFactory sqlSessionFactory;
     private SqlSession session;
     private UserMapper userMapper;
     @Before
    public void init() throws IOException {
         InputStream inputStream= Resources.getResourceAsStream(mybatisconfig);
         sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
         this.session=this.sqlSessionFactory.openSession();
         userMapper=session.getMapper(UserMapper.class);
     }
     @After
    public void destory(){
         session.commit();
         session.close();
     }
     @Test
    public void testQueryById(){
        int userid=4;
         Tbuser tbuser=this.userMapper.queryUserById(userid);
         System.out.println("tbuser = " + tbuser);
     }
     @Test
    public void testQueryCount(){
         int max=this.userMapper.queryUserCount();
         System.out.println("max = " + max);
     }
     @Test
    public void testQueryByusername(){
         String username="yangkai";
         Tbuser tbuser=userMapper.queryUserByusername(username);
         System.out.println("tbuser = " + tbuser);
     }
     @Test
    public void testLogin(){
         Tbuser tbuser=new Tbuser("doudou","66666");
         Tbuser login=this.userMapper.login(tbuser);
         System.out.println("login = " + login);
     }
     @Test
    public void testQueryUsers(){
         Tbuser tbuser=new Tbuser();
         tbuser.setUsername("yang");
         tbuser.setUserroles("02");
         List<Tbuser> tbusers=this.userMapper.queryUsers(tbuser);
         tbusers.forEach(u->System.out.println(u));
     }
     private void print(int row){
         if(row>0){
             System.out.println("操作成功");
         }else{
             System.out.println("操作失败");
         }
     }
     @Test
    public void testAddUser(){
         Tbuser tbuser=new Tbuser(0,"yangxinyue","99999","02","tufei",null);
         int row=this.userMapper.addUser(tbuser);
         print(row);
     }
     @Test
     public void testUpdateUser(){
         Tbuser tbuser=new Tbuser(13,"","1777","03",null,null);
         int row=this.userMapper.updateUser(tbuser);
         print(row);
     }
     @Test
    public void testDeleteUser(){
         int userid=15;
         int row=this.userMapper.deleteUser(userid);
         print(row);
     }

     @Test
    public void testLogin1(){
         String username="admin";
         String pwd="1234";
         Tbuser tbuser=this.userMapper.login1(username,pwd);
         System.out.println("tbuser = " + tbuser);
     }
     @Test
    public void testLogin2(){
         String uname="admin";
         String pwd="1234";
         Tbuser tbuser=this.userMapper.login2(uname,pwd);
         System.out.println("tbuser = " + tbuser);
     }
     @Test
    public void testLogin3(){
         String username="admin",password="1234";
         Map<String,Object> map=new HashMap<>();
         map.put("uname",username);
         map.put("pwd",password);
         Tbuser tbuser=this.userMapper.login3(map);
         System.out.println("tbuser = " + tbuser);
     }
     @Test
    public void testLogin4(){
         Tbuser u=new Tbuser("admin","1234");
         Tbuser tbuser=this.userMapper.login4(u);
         System.out.println("tbuser = " + tbuser);
     }
     @Test
    public void testDeleteUsers(){
         int ids[]={16,17,18};
         int row=this.userMapper.deleteUsers(ids);
         this.print(row);
     }
}
