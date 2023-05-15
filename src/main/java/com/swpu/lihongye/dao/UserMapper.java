package com.swpu.lihongye.dao;

import com.swpu.lihongye.pojo.Class;
import com.swpu.lihongye.pojo.Student;
import com.swpu.lihongye.pojo.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public interface UserMapper {
    //查询老师
    List<Teacher> teacherSearch(@Param("workInfo")Long workInfo,@Param("teacherName")String teacherName);
    //查询班级
    List<Class> classSearch(@Param("classInfo")Long classInfo);
    //查询学生
    List<Student> studentSearch(@Param("studentName")String studentName,@Param("studentInfo")Long studentInfo);
    void teacherInsert(Teacher teacher);
    void studentInsert(Student student);
    void classInsert(Class classroom);

}
