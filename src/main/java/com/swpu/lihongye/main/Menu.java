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
        System.out.println("��ӭʹ�ð༶����ϵͳ��");
        System.out.println("��ѡ��Ҫʹ�õĹ��ܣ�");
        System.out.println("0.�˳�ϵͳ");
        System.out.println("1.�༶��ѯ");
        System.out.println("2.��ʦ��ѯ");
        System.out.println("3.ѧ����ѯ");
        System.out.println("4.��Ϣ���");

    }

    public void selectFunction() {
        int chooseFirst;
        boolean exitBool = true;
        while (exitBool) {
            showMenu();
            chooseFirst = InputUtil.getIntInput(scanner);
            switch (chooseFirst) {
                case 0:
                    System.out.println("���˳�ϵͳ��");
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
                    System.out.println("ָ���������������룡");
                    break;
            }
        }
    }

    private void addInfo(Scanner scanner) {
        boolean exitBool=true;
        while (exitBool){
            System.out.println("��ѡ����ӵ����ݣ�");
            System.out.println("0.�˳�ϵͳ");
            System.out.println("1.���ѧ����Ϣ");
            System.out.println("2.�����ʦ��Ϣ");
            System.out.println("3.��ӽ�ʦ��Ϣ");
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
                    System.out.println("����������������ȷ����ţ�");
                    break;
            }
        }
    }
    private void addStudent(Scanner scanner){
        System.out.println("������ѧ��������");
        String name=InputUtil.getStringInput(scanner);
        System.out.println("������ѧ��ѧ�ţ�");
        String id=InputUtil.getStringInput(scanner);
        System.out.println("������ѧ������");
        int age=InputUtil.getIntInput(scanner);
        System.out.println("������ѧ���ֻ���");
        long phone=InputUtil.getLongInput(scanner);
        System.out.println("������ѧ����ַ");
        String address=InputUtil.getStringInput(scanner);
        Student student=new Student(name,id,age,phone,address);
        try {
            mapper.studentInsert(student);
            sqlSession.commit();
        } catch (PersistenceException e) {
            System.out.println("���ʧ�ܣ�����ԭ�򣺸�ѧ����ʹ��");
        }
    }
    private void addTeacher(Scanner scanner){
        System.out.println("�������ʦ������");
        String name=InputUtil.getStringInput(scanner);
        System.out.println("��������ʦ����");
        long id=InputUtil.getLongInput(scanner);
        System.out.println("��������ʦ�Ա�");
        char sex=InputUtil.getCharInput(scanner);
        System.out.println("��������ʦ�ֻ���");
        long phone=InputUtil.getLongInput(scanner);
        System.out.println("��������ʦ��ַ");
        String address=InputUtil.getStringInput(scanner);
        Teacher teacher=new Teacher(name,id,sex,phone,address);
        try {
            mapper.teacherInsert(teacher);
            sqlSession.commit();
        } catch (PersistenceException e) {
            System.out.println("���ʧ�ܣ�����ԭ�򣺸ù�����ʹ��");
        }
    }
    private void addClass(Scanner scanner){
        System.out.println("�������ţ�");
        long info=InputUtil.getLongInput(scanner);
        System.out.println("������༶���ƣ�");
        String name=InputUtil.getStringInput(scanner);
        System.out.println("��������������ƣ�");
        String  teacherName=InputUtil.getStringInput(scanner);
        System.out.println("����������ι��ţ�");
        long teacher=InputUtil.getLongInput(scanner);
        Class newClass=new Class(teacherName,info,teacher,name);
        try {
            mapper.classInsert(newClass);
            sqlSession.commit();
        }catch (PersistenceException e){
            System.out.println("���ʧ�ܣ�����ԭ�򣺸ð����ʹ��!");
        }
    }

    private void classQuery(Scanner sc) {
        boolean exitBool = true;
        while (exitBool) {
            System.out.println("0.�˳�");
            System.out.println("1.��Ų�ѯ");
            System.out.println("2.��ѯ����");
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
                    System.out.println("ָ���������������");
                    break;
            }
        }
        // ����༶��ѯ�Ĵ���
    }
    public void classFind(Long classInfo){
        List<Class> classList=mapper.classSearch(classInfo);
        String notify=classList.isEmpty()?"��ѯ���Ϊ��":"";
        classList.forEach(System.out::println);
        System.out.println(notify);
    }

    private void teacherQuery(Scanner sc) {
        // �����ʦ��ѯ�Ĵ���
        boolean exitBool = true;
        while (exitBool) {
            System.out.println("��ѡ��Ҫʹ�õĹ��ܣ�");
            System.out.println("0.�˳�");
            System.out.println("1.�����Ų�ѯ");
            System.out.println("2.�����ֲ�ѯ");
            System.out.println("3.��ѯ����");
            int choose = sc.nextInt();
            switch (choose) {
                case 0:
                    exitBool = false;
                    break;
                case 1:
                    System.out.println("�����빤�ţ�");
                    long workInfo = InputUtil.getLongInput(sc);
                    teacherFind(workInfo,null);
                    break;
                case 2:
                    System.out.println("����������");
                    String name = InputUtil.getStringInput(sc);
                    teacherFind(null,name);
                    break;
                case 3:
                    teacherFind(null,null);
                    break;
                default:
                    System.out.println("�����������������룡");
                    break;
            }
        }
    }
    public void teacherFind(Long workInfo,String teacherName){
        List<Teacher> teachers =mapper.teacherSearch(workInfo,teacherName);
        System.out.println("��ѯ���Ϊ:");
        String notify=teachers.isEmpty()?"��ѯ���Ϊ��":"";
        teachers.forEach(System.out::println);
        System.out.println(notify);
    }

    private void studentQuery(Scanner sc) {
        // ����ѧ����ѯ�Ĵ���
        boolean exitBool = true;
        while (exitBool) {
            System.out.println("��ѡ��Ҫʹ�õĹ��ܣ�");
            System.out.println("0.�˳�");
            System.out.println("1.��ѧ�Ų�ѯ");
            System.out.println("2.�����ֲ�ѯ");
            System.out.println("3.ȫ����ѯ");
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
                    System.out.println("�����������������룡");
                    break;
            }
        }
    }
    public void studentFind(String stuName,Long stuID){
        List<Student> students=mapper.studentSearch(stuName,stuID);
        String notify=students.isEmpty()?"��ѯ���Ϊ��":"";
        students.forEach(System.out::println);
        System.out.println(notify);
    }
}
