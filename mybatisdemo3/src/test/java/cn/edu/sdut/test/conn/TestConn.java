package cn.edu.sdut.test.conn;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;

public class TestConn {
    private String mybatisconfig="mybatis.xml";

    private SqlSessionFactory sqlSessionFactory;
    private SqlSession session;
    @Before
    public void init(){
        try {
            InputStream inputStream= null;
            inputStream = Resources.getResourceAsStream(mybatisconfig);
            sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
            this.session=sqlSessionFactory.openSession();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testConn(){
        Connection connection=session.getConnection();
        System.out.println("connection = " + connection);
    }
}
