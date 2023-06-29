package com.swpu.lihongye.service;

import com.swpu.lihongye.pojo.ClassMessage;
import com.swpu.lihongye.pojo.Student;
import com.swpu.lihongye.pojo.StudentMessage;

import java.util.List;

public interface StudentService {
    List<StudentMessage> getAllStudents();
}
