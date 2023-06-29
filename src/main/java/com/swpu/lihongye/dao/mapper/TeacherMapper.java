package com.swpu.lihongye.dao.mapper;


import com.swpu.lihongye.pojo.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeacherMapper {
    void addTeacher(Teacher teacher);
    void deleteTeacher(@Param("workInfo")Long workInfo);
    void updateTeacher(@Param("teacherPojo")Teacher teacher,@Param("workInfo")Long workInfo);
    List<Teacher> searchTeacher(@Param("workInfo")Long workInfo,@Param("teacherName")String teacherName);
}
