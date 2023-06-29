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
    String add="��������",delete="ɾ������",update="�޸�����",search="��������";
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
        menuUtil.addOption("ѧ������",this::studentManager);
        menuUtil.addOption("��ʦ����",this::teacherManager);
        menuUtil.addOption("���ҹ���",this::classManager);
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
        System.out.println("������Ҫ��ӵ�ѧ����Ϣ:");
        System.out.println("ѧ�ţ�");
        long studentId= InputUtil.getLongInput(scanner);
        System.out.println("������");
        String studentName=InputUtil.getStringInput(scanner);
        System.out.println("���䣺");
        int age=InputUtil.getIntInput(scanner);
        System.out.println("�绰��");
        long phone=InputUtil.getLongInput(scanner);
        System.out.println("ѧУ��ַ��");
        String address=InputUtil.getStringInput(scanner);
        Student student=new Student(studentName,studentId,age,phone,address);
        try {
            studentMapper.addStu(student);
            System.out.println("��ӳɹ�");
            sqlSession.commit();
            scanner.next();
        } catch (PersistenceException e) {
            System.out.println("���ʧ�ܣ�ѧ���Ѵ���");
        }
    }
    private void studentDelete(){
        System.out.println("������Ҫɾ����ѧ��ѧ�ţ�");
        Long studentId=InputUtil.getLongInput(scanner);
        try {
            System.out.println(studentId);
            studentMapper.deleteStu(studentId);
            sqlSession.commit();
            System.out.println("ɾ���ɹ���");
            scanner.next();
        }catch (Exception e){
            System.out.println("ɾ��ʧ�ܣ�");
            scanner.next();
        }
    }

    private void studentUpdate(){
        int choose;
        boolean exitBool=true;
        System.out.println("������Ҫ�޸�ѧ����ѧ�ţ�");
        long stuId=InputUtil.getLongInput(scanner);
        while (exitBool){
            System.out.println("ѡ��Ҫ�޸ĵ����ݣ�");
            System.out.println("0.�˳�");
            System.out.println("1.����");
            System.out.println("2.����");
            System.out.println("3.�绰");
            System.out.println("4.��ַ");
            choose= InputUtil.getIntInput(scanner);
            switch (choose){
                case 0:
                    exitBool=false;
                    break;
                case 1:
                    System.out.println("������������");
                    String name=InputUtil.getStringInput(scanner);
                    try {
                        List<Student> students=studentMapper.searchStu(stuId,null);
                        Student student=students.get(0);
                        student.setStudentName(name);
                        studentMapper.update(student,stuId);
                        sqlSession.commit();
                        System.out.println("�޸ĳɹ�!");
                    }catch (Exception e){
                        System.out.println("�޸�ʧ��");
                    }
                    break;
                case 2:
                    System.out.println("������������");
                    int age=InputUtil.getIntInput(scanner);
                    try {
                        studentMapper.update(new Student(null,null,age,null,null),stuId);
                        sqlSession.commit();
                        System.out.println("�޸ĳɹ�!");
                    }catch (Exception e){
                        System.out.println("�޸�ʧ��");
                    }
                    break;
                case 3:
                    System.out.println("�������µ绰");
                    long phone=InputUtil.getLongInput(scanner);
                    try {
                        studentMapper.update(new Student(null,null,null,phone,null),stuId);
                        sqlSession.commit();
                        System.out.println("�޸ĳɹ�!");
                    }catch (Exception e){
                        System.out.println("�޸�ʧ��");
                    }
                    break;
                case 4:
                    System.out.println("�������µ�ַ");
                    String address=InputUtil.getStringInput(scanner);
                    try {
                        studentMapper.update(new Student(null,null,null,null,address),stuId);
                        sqlSession.commit();
                        System.out.println("�޸ĳɹ�!");
                    }catch (Exception e){
                        System.out.println("�޸�ʧ��");
                    }
                    break;
                default:
                    System.out.println("�����������������룡");
                    break;
            }
        }
    }

    private void studentSearch(){
        boolean exitBool=true;
        while (exitBool){
            System.out.println("��ѡ��");
            System.out.println("1.ѧ��");
            System.out.println("2.����");
            int choose=InputUtil.getIntInput(scanner);
            switch (choose){
                case 0:
                    exitBool=false;
                    break;
                case 1:
                    System.out.println("������ѧ�ţ�");
                    long studentId=InputUtil.getLongInput(scanner);
                    List<Student> students=studentMapper.searchStu(studentId,null);
                    String notify=students.isEmpty()?"û���ҵ�����":"";
                    students.forEach(System.out::println);
                    System.out.println(notify);
                    break;
                case 2:
                    System.out.println("������������");
                    String name=InputUtil.getStringInput(scanner);
                    List<Student> studentList=studentMapper.searchStu(null,name);
                    String notify2=studentList.isEmpty()?"û���ҵ�����":"";
                    studentList.forEach(System.out::println);
                    System.out.println(notify2);
                    break;
                default:
                    System.out.println("��������");
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
