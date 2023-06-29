package com.swpu.lihongye.main;

import com.swpu.lihongye.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        //获取SqlSession
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        Menu menu=new Menu(sqlSession);
        menu.showMainMenu();
        sqlSession.close();
    }
}
