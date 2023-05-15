package com.swpu.lihongye.main;

import com.swpu.lihongye.dao.UserMapper;
import com.swpu.lihongye.pojo.Class;
import com.swpu.lihongye.pojo.Student;
import com.swpu.lihongye.pojo.Teacher;
import com.swpu.lihongye.utils.InputUtil;
import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Scanner;

public class Menu {

    private final Scanner scanner;
    private final UserMapper mapper;
    private final SqlSession sqlSession;

    public Menu(UserMapper mapper,SqlSession sqlSession) {
        this.sqlSession=sqlSession;
        this.mapper = mapper;
        this.scanner = new Scanner(System.in);
    }

    private void showMenu() {
        System.out.println("欢迎使用班级管理系统！");
        System.out.println("请选择要使用的功能：");
        System.out.println("0.退出系统");
        System.out.println("1.班级查询");
        System.out.println("2.教师查询");
        System.out.println("3.学生查询");
        System.out.println("4.信息添加");

    }

    public void selectFunction() {
        int chooseFirst;
        boolean exitBool = true;
        while (exitBool) {
            showMenu();
            chooseFirst = InputUtil.getIntInput(scanner);
            switch (chooseFirst) {
                case 0:
                    System.out.println("已退出系统！");
                    exitBool = false;
                    break;
                case 1:
                    classQuery(scanner);
                    break;
                case 2:
                    teacherQuery(scanner);
                    break;
                case 3:
                    studentQuery(scanner);
                    break;
                case 4:
                    addInfo(scanner);
                    break;
                default:
                    System.out.println("指令有误！请重新输入！");
                    break;
            }
        }
    }

    private void addInfo(Scanner scanner) {
        boolean exitBool=true;
        while (exitBool){
            System.out.println("请选择添加的数据：");
            System.out.println("0.退出系统");
            System.out.println("1.添加学生信息");
            System.out.println("2.添加老师信息");
            System.out.println("3.添加教师信息");
            int choose=InputUtil.getIntInput(scanner);
            switch (choose){
                case 0:
                    exitBool=false;
                case 1:
                    addStudent(scanner);
                    break;
                case 2:
                    addTeacher(scanner);
                    break;
                case 3:
                    addClass(scanner);
                    break;
                default:
                    System.out.println("输入有误，请输入正确的序号！");
                    break;
            }
        }
    }
    private void addStudent(Scanner scanner){
        System.out.println("请输入学生姓名：");
        String name=InputUtil.getStringInput(scanner);
        System.out.println("请输入学生学号！");
        String id=InputUtil.getStringInput(scanner);
        System.out.println("请输入学生年龄");
        int age=InputUtil.getIntInput(scanner);
        System.out.println("请输入学生手机号");
        long phone=InputUtil.getLongInput(scanner);
        System.out.println("请输入学生地址");
        String address=InputUtil.getStringInput(scanner);
        Student student=new Student(name,id,age,phone,address);
        try {
            mapper.studentInsert(student);
            sqlSession.commit();
        } catch (PersistenceException e) {
            System.out.println("添加失败！错误原因：该学号已使用");
        }
    }
    private void addTeacher(Scanner scanner){
        System.out.println("请输入教师姓名：");
        String name=InputUtil.getStringInput(scanner);
        System.out.println("请输入老师工号");
        long id=InputUtil.getLongInput(scanner);
        System.out.println("请输入老师性别");
        char sex=InputUtil.getCharInput(scanner);
        System.out.println("请输入老师手机号");
        long phone=InputUtil.getLongInput(scanner);
        System.out.println("请输入老师地址");
        String address=InputUtil.getStringInput(scanner);
        Teacher teacher=new Teacher(name,id,sex,phone,address);
        try {
            mapper.teacherInsert(teacher);
            sqlSession.commit();
        } catch (PersistenceException e) {
            System.out.println("添加失败！错误原因：该工号已使用");
        }
    }
    private void addClass(Scanner scanner){
        System.out.println("请输入班号：");
        long info=InputUtil.getLongInput(scanner);
        System.out.println("请输入班级名称：");
        String name=InputUtil.getStringInput(scanner);
        System.out.println("请输入班主任名称：");
        String  teacherName=InputUtil.getStringInput(scanner);
        System.out.println("请输入班主任工号：");
        long teacher=InputUtil.getLongInput(scanner);
        Class newClass=new Class(teacherName,info,teacher,name);
        try {
            mapper.classInsert(newClass);
            sqlSession.commit();
        }catch (PersistenceException e){
            System.out.println("添加失败！错误原因：该班号已使用!");
        }
    }

    private void classQuery(Scanner sc) {
        boolean exitBool = true;
        while (exitBool) {
            System.out.println("0.退出");
            System.out.println("1.班号查询");
            System.out.println("2.查询所有");
            int choose = InputUtil.getIntInput(sc);
            switch (choose) {
                case 0:
                    exitBool = false;
                    break;
                case 1:
                    long info = InputUtil.getLongInput(sc);
                    classFind(info);
                    break;
                case 2:
                    classFind(null);
                    break;
                default:
                    System.out.println("指令错误！请重新输入");
                    break;
            }
        }
        // 处理班级查询的代码
    }
    public void classFind(Long classInfo){
        List<Class> classList=mapper.classSearch(classInfo);
        String notify=classList.isEmpty()?"查询结果为空":"";
        classList.forEach(System.out::println);
        System.out.println(notify);
    }

    private void teacherQuery(Scanner sc) {
        // 处理教师查询的代码
        boolean exitBool = true;
        while (exitBool) {
            System.out.println("请选择要使用的功能：");
            System.out.println("0.退出");
            System.out.println("1.按工号查询");
            System.out.println("2.按名字查询");
            System.out.println("3.查询所有");
            int choose = sc.nextInt();
            switch (choose) {
                case 0:
                    exitBool = false;
                    break;
                case 1:
                    System.out.println("请输入工号：");
                    long workInfo = InputUtil.getLongInput(sc);
                    teacherFind(workInfo,null);
                    break;
                case 2:
                    System.out.println("请输入名字");
                    String name = InputUtil.getStringInput(sc);
                    teacherFind(null,name);
                    break;
                case 3:
                    teacherFind(null,null);
                    break;
                default:
                    System.out.println("输入有误！请重新输入！");
                    break;
            }
        }
    }
    public void teacherFind(Long workInfo,String teacherName){
        List<Teacher> teachers =mapper.teacherSearch(workInfo,teacherName);
        System.out.println("查询结果为:");
        String notify=teachers.isEmpty()?"查询结果为空":"";
        teachers.forEach(System.out::println);
        System.out.println(notify);
    }

    private void studentQuery(Scanner sc) {
        // 处理学生查询的代码
        boolean exitBool = true;
        while (exitBool) {
            System.out.println("请选择要使用的功能：");
            System.out.println("0.退出");
            System.out.println("1.按学号查询");
            System.out.println("2.按名字查询");
            System.out.println("3.全部查询");
            int choose = InputUtil.getIntInput(sc);
            switch (choose) {
                case 0:
                    exitBool = false;
                    break;
                case 1:
                    long info = InputUtil.getLongInput(sc);
                    studentFind(null,info);
                    break;
                case 2:
                    String name = InputUtil.getStringInput(sc);
                    studentFind(name,null);
                    break;
                case 3:
                    break;
                default:
                    System.out.println("输入有误，请重新输入！");
                    break;
            }
        }
    }
    public void studentFind(String stuName,Long stuID){
        List<Student> students=mapper.studentSearch(stuName,stuID);
        String notify=students.isEmpty()?"查询结果为空":"";
        students.forEach(System.out::println);
        System.out.println(notify);
    }
}
