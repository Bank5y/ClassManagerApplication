package com.swpu.lihongye.main;


import com.swpu.lihongye.dao.mapper.ClassMapper;
import com.swpu.lihongye.dao.mapper.StudentMapper;
import com.swpu.lihongye.dao.mapper.TeacherMapper;
import com.swpu.lihongye.pojo.Student;
import com.swpu.lihongye.utils.InputUtil;
import com.swpu.lihongye.utils.MenuUtil;
import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Scanner;

public class Menu {
    MenuUtil menuUtil=new MenuUtil();
    String add="增加数据",delete="删除数据",update="修改数据",search="查找数据";
    SqlSession sqlSession;
    StudentMapper studentMapper;
    ClassMapper classMapper;
    TeacherMapper teacherMapper;
    Scanner scanner;

    public Menu(SqlSession sqlSession) {
        this.sqlSession=sqlSession;
        studentMapper=sqlSession.getMapper(StudentMapper.class);
        classMapper=sqlSession.getMapper(ClassMapper.class);
        teacherMapper=sqlSession.getMapper(TeacherMapper.class);
    }

    public void showMainMenu(){
        start();
        menuUtil.runMenu();
    }
    public void start(){
        scanner=new Scanner(System.in);
        menuUtil.addOption("学生管理",this::studentManager);
        menuUtil.addOption("老师管理",this::teacherManager);
        menuUtil.addOption("教室管理",this::classManager);
    }

    private void studentManager(){
        MenuUtil studentMenu=new MenuUtil();
        studentMenu.addOption(add,this::studentInsert);
        studentMenu.addOption(delete,this::studentDelete);
        studentMenu.addOption(update,this::studentUpdate);
        studentMenu.addOption(search,this::studentSearch);
        studentMenu.runMenu();
    }
    private void studentInsert(){
        System.out.println("请输入要添加的学生信息:");
        System.out.println("学号：");
        long studentId= InputUtil.getLongInput(scanner);
        System.out.println("姓名：");
        String studentName=InputUtil.getStringInput(scanner);
        System.out.println("年龄：");
        int age=InputUtil.getIntInput(scanner);
        System.out.println("电话：");
        long phone=InputUtil.getLongInput(scanner);
        System.out.println("学校地址：");
        String address=InputUtil.getStringInput(scanner);
        Student student=new Student(studentName,studentId,age,phone,address);
        try {
            studentMapper.addStu(student);
            System.out.println("添加成功");
            sqlSession.commit();
            scanner.next();
        } catch (PersistenceException e) {
            System.out.println("添加失败！学号已存在");
        }
    }
    private void studentDelete(){
        System.out.println("请输入要删除的学生学号：");
        Long studentId=InputUtil.getLongInput(scanner);
        try {
            System.out.println(studentId);
            studentMapper.deleteStu(studentId);
            sqlSession.commit();
            System.out.println("删除成功！");
            scanner.next();
        }catch (Exception e){
            System.out.println("删除失败！");
            scanner.next();
        }
    }

    private void studentUpdate(){
        int choose;
        boolean exitBool=true;
        System.out.println("请输入要修改学生的学号：");
        long stuId=InputUtil.getLongInput(scanner);
        while (exitBool){
            System.out.println("选择要修改的数据：");
            System.out.println("0.退出");
            System.out.println("1.名字");
            System.out.println("2.年龄");
            System.out.println("3.电话");
            System.out.println("4.地址");
            choose= InputUtil.getIntInput(scanner);
            switch (choose){
                case 0:
                    exitBool=false;
                    break;
                case 1:
                    System.out.println("请输入新名字");
                    String name=InputUtil.getStringInput(scanner);
                    try {
                        List<Student> students=studentMapper.searchStu(stuId,null);
                        Student student=students.get(0);
                        student.setStudentName(name);
                        studentMapper.update(student,stuId);
                        sqlSession.commit();
                        System.out.println("修改成功!");
                    }catch (Exception e){
                        System.out.println("修改失败");
                    }
                    break;
                case 2:
                    System.out.println("请输入新年龄");
                    int age=InputUtil.getIntInput(scanner);
                    try {
                        studentMapper.update(new Student(null,null,age,null,null),stuId);
                        sqlSession.commit();
                        System.out.println("修改成功!");
                    }catch (Exception e){
                        System.out.println("修改失败");
                    }
                    break;
                case 3:
                    System.out.println("请输入新电话");
                    long phone=InputUtil.getLongInput(scanner);
                    try {
                        studentMapper.update(new Student(null,null,null,phone,null),stuId);
                        sqlSession.commit();
                        System.out.println("修改成功!");
                    }catch (Exception e){
                        System.out.println("修改失败");
                    }
                    break;
                case 4:
                    System.out.println("请输入新地址");
                    String address=InputUtil.getStringInput(scanner);
                    try {
                        studentMapper.update(new Student(null,null,null,null,address),stuId);
                        sqlSession.commit();
                        System.out.println("修改成功!");
                    }catch (Exception e){
                        System.out.println("修改失败");
                    }
                    break;
                default:
                    System.out.println("输入有误！请重新输入！");
                    break;
            }
        }
    }

    private void studentSearch(){
        boolean exitBool=true;
        while (exitBool){
            System.out.println("请选择：");
            System.out.println("1.学号");
            System.out.println("2.姓名");
            int choose=InputUtil.getIntInput(scanner);
            switch (choose){
                case 0:
                    exitBool=false;
                    break;
                case 1:
                    System.out.println("请输入学号：");
                    long studentId=InputUtil.getLongInput(scanner);
                    List<Student> students=studentMapper.searchStu(studentId,null);
                    String notify=students.isEmpty()?"没有找到数据":"";
                    students.forEach(System.out::println);
                    System.out.println(notify);
                    break;
                case 2:
                    System.out.println("请输入姓名：");
                    String name=InputUtil.getStringInput(scanner);
                    List<Student> studentList=studentMapper.searchStu(null,name);
                    String notify2=studentList.isEmpty()?"没有找到数据":"";
                    studentList.forEach(System.out::println);
                    System.out.println(notify2);
                    break;
                default:
                    System.out.println("输入有误！");
                    break;
            }
        }
    }

    private void teacherManager(){
        MenuUtil teacherMenu=new MenuUtil();
    }
    private void classManager(){
        MenuUtil classMenu=new MenuUtil();
    }
}
