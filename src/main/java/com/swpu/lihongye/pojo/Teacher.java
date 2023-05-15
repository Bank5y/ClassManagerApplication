package com.swpu.lihongye.pojo;

public class Teacher{
private String  teacherName;
private long    workInfo;
private char    sex;
private long    phone;
private String  address;

    public Teacher() {
    }

    public Teacher(String teacherName, long workInfo, char sex, long phone, String address) {
        this.teacherName = teacherName;
        this.workInfo = workInfo;
        this.sex = sex;
        this.phone = phone;
        this.address = address;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public long getWorkInfo() {
        return workInfo;
    }

    public void setWorkInfo(long workInfo) {
        this.workInfo = workInfo;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "教师姓名："+teacherName+"，工号："+workInfo+"，性别："+sex+"，电话："+phone+"，学校："+address;

    }
}
