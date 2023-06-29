package com.swpu.lihongye.service;

import com.swpu.lihongye.dao.mapper.ClassMessageMapper;
import com.swpu.lihongye.pojo.ClassMessage;

import java.util.List;

public class ClassServiceImpl implements ClassService{
    private ClassMessageMapper classMessageMapper;
    public ClassMessageMapper getClassMessageMapper(){
        return classMessageMapper;
    }

    public void setClassMessageMapper(ClassMessageMapper classMessageMapper) {
        this.classMessageMapper = classMessageMapper;
    }

    @Override
    public List<ClassMessage> getAllClass(){
        return classMessageMapper.getAllClass();
    }
}
