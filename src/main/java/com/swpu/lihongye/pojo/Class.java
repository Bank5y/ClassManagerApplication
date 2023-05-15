package com.swpu.lihongye.pojo;

public class Class {
    private long classInfo;
    private long workInfo;
    private String className;
    private String classTeacher;

    public Class() {
    }

    public Class( String classTeacher, long classInfo, long workInfo,String className) {
        this.classInfo = classInfo;
        this.workInfo = workInfo;
        this.className = className;
        this.classTeacher = classTeacher;
    }

    public long getClassInfo() {
        return classInfo;
    }

    public void setClassInfo(long classInfo) {
        this.classInfo = classInfo;
    }

    public long getWorkInfo() {
        return workInfo;
    }

    public void setWorkInfo(long workInfo) {
        this.workInfo = workInfo;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getClassTeacher() {
        return classTeacher;
    }

    public void setClassTeacher(String classTeacher) {
        this.classTeacher = classTeacher;
    }

    @Override
    public String toString() {
        return "班级号："+ getClassInfo()+
                "，班级名："+ getClassName()+"，班主任："+ getClassTeacher()+"，老师工号："+ getWorkInfo();
    }
}
