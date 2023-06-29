package com.swpu.lihongye.dao.mapper;

import com.swpu.lihongye.pojo.Class;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ClassMapper{
    void updateClass(@Param("classPojo")Class newClass,@Param("classInfo")Long classInfo);


    void deleteClass(Long classInfo);


    List<Class> classSearch(@Param("classInfo")Long classInfo);

    void classInsert(Class newClass);
}
