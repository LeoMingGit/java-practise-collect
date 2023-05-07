package cn.edu.sdut.test.student;

import cn.edu.sdut.entity.Grade;
import cn.edu.sdut.entity.Student;
import cn.edu.sdut.mapper.StudentMapper;
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
import java.util.List;

public class TestStudent {
    private String mybatisconfig="mybatis.xml";

    private SqlSessionFactory sqlSessionFactory;
    private SqlSession session;
    private StudentMapper studentMapper;
    @Before
    public void init() throws IOException {
        InputStream inputStream= Resources.getResourceAsStream(mybatisconfig);
        sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
        this.session=this.sqlSessionFactory.openSession();
        studentMapper=session.getMapper(StudentMapper.class);
    }
    @After
    public void destory(){
        session.commit();
        session.close();
    }
    private void print(int row){
        if(row>0){
            System.out.println("操作成功");
        }else{
            System.out.println("操作失败");
        }
    }
    @Test
    public void testAddStudent(){
        Grade grade=new Grade();
        grade.setGradeid(3);
        Student student=new Student(grade,0,"郑亚明","02","9758",20);
        this.print(this.studentMapper.addStudent(student));
    }
    @Test
    public void testQueryStudentById(){
        int stuid=1;
        Student student=this.studentMapper.queryStudentById(stuid);
        System.out.println("student = " + student);
    }
    @Test
    public void testQueryStudents(){
        List<Student> students=this.studentMapper.queryStudents();
        students.forEach(s-> System.out.println("s = " + s));
    }
}
