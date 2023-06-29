package com.swpu.lihongye.dao.mapper;

import com.swpu.lihongye.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentMapper {
    void addStu(Student student);
    void deleteStu(@Param("StudentId")Long studentId);
    void update(@Param("studentPojo")Student student,@Param("studentId")Long studentId);

    List<Student> searchStu(@Param("studentId") Long studentId, @Param("stuName") String stuName);
}
