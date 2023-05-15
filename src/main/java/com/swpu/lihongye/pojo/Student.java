package com.swpu.lihongye.pojo;

public class Student{
private String studentName;
private String studentId;
private int age;
private long phone;
private String address;

    public Student() {
    }

    public Student(String studentName, String studentId, int age, long phone, String address) {
        this.studentName = studentName;
        this.studentId = studentId;
        this.age = age;
        this.phone = phone;
        this.address = address;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
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
        return "������"+studentName+"��ѧ�ţ�"+studentId+"�����䣺"+age+",�绰"+phone+"��ѧУ��"+ address;
    }
}
