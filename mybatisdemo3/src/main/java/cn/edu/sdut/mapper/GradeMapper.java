package cn.edu.sdut.mapper;

import cn.edu.sdut.entity.Grade;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GradeMapper {

    int addGrade(@Param("grade") Grade grade);
    int updateGrade(@Param("grade") Grade grade);
    List<Grade> queryGrades();
    Grade queryGradeById(int gradeid);
}
