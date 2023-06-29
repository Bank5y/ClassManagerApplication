package com.swpu.lihongye.service;

import com.swpu.lihongye.dao.mapper.StudentMessageMapper;
import com.swpu.lihongye.pojo.StudentMessage;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    private StudentMessageMapper studentMessageMapper;

    public StudentMessageMapper getStudentMessageMapper() {
        return studentMessageMapper;
    }

    public void setStudentMessageMapper(StudentMessageMapper studentMessageMapper) {
        this.studentMessageMapper = studentMessageMapper;
    }
    @Override
    public List<StudentMessage> getAllStudents() {
        return studentMessageMapper.getAllStudents();
    }

}
