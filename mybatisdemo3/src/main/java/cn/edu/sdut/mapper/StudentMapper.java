package cn.edu.sdut.mapper;

import cn.edu.sdut.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentMapper {
    int addStudent(@Param("student") Student student);
    List<Student> queryStudents();
    Student queryStudentById(int stuid);
}
