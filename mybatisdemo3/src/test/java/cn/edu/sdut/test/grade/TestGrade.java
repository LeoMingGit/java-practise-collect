package cn.edu.sdut.test.grade;

import cn.edu.sdut.entity.Grade;
import cn.edu.sdut.entity.Student;
import cn.edu.sdut.mapper.GradeMapper;
import cn.edu.sdut.mapper.UserMapper;
import org.apache.ibatis.annotations.Param;
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

public class TestGrade {
    private String mybatisconfig="mybatis.xml";

    private SqlSessionFactory sqlSessionFactory;
    private SqlSession session;
    private GradeMapper gradeMapper;
    @Before
    public void init() throws IOException {
        InputStream inputStream= Resources.getResourceAsStream(mybatisconfig);
        sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
        this.session=this.sqlSessionFactory.openSession();
        gradeMapper=session.getMapper(GradeMapper.class);
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
    public void testAddGrade(){
        Grade grade=new Grade(0,"计科1904");
        int row=this.gradeMapper.addGrade(grade);
        print(row);
    }
    @Test
    public void testUpdateGrade(){
        Grade grade=new Grade(7,"计科2014");
        int row=this.gradeMapper.updateGrade(grade);
        print(row);
    }
    @Test
    public void testQueryGradeById(){
        int gradid=3;
        Grade grade=this.gradeMapper.queryGradeById(gradid);
        List<Student> students=grade.getStudents();
        for(Student s:students){
            System.out.println(grade.getGradename()+"\t"+s.getStuname());
        }
    }
    @Test
    public void testQueryGrades(){
        List<Grade> grades=this.gradeMapper.queryGrades();
        grades.forEach(g-> System.out.println("grade = " + g));
    }
}
