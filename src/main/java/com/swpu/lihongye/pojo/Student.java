package com.swpu.lihongye.pojo;

public class Student{
private String studentName;
private Long studentId;
private int age;
private Long phone;
private String address;


    public Student() {
    }

    public Student(String studentName, Long studentId, Integer age, Long phone, String address) {
        this.studentName = studentName;
        this.studentId = studentId;
        this.age = age;
        this.phone = phone;
        this.address = address;
    }

    //setter&getter


    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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
        return "姓名："+studentName+"，学号："+studentId+
                "，年龄："+age+",电话"+phone+"，学校："+ address;
    }
}
