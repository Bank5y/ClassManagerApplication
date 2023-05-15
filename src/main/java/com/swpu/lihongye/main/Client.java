package com.swpu.lihongye.main;

import com.swpu.lihongye.dao.UserMapper;
import com.swpu.lihongye.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
    SqlSession sqlSession=MybatisUtils.getSqlSession();
    UserMapper mapper=sqlSession.getMapper(UserMapper.class);
    Scanner scanner=new Scanner(System.in);

    Menu menu=new Menu(mapper,sqlSession);
    menu.selectFunction();
    sqlSession.close();
    }
}
