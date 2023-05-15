package com.swpu.lihongye.utils;

import com.mysql.jdbc.interceptors.ResultSetScannerInterceptor;

import java.util.Scanner;

public class InputUtil {
    public static int getIntInput(Scanner scanner) {
        int num;
        while (true) {
            System.out.println("请输入一个整数：");
            if (scanner.hasNextInt()) {
                num = scanner.nextInt();
                break;
            } else {
                System.out.println("输入有误，请重新输入。");
                scanner.next(); // 清除错误的输入
            }
        }
        return num;
    }

    public static char getCharInput(Scanner scanner) {
        char c;
        while (true) {
            System.out.println("请输入一个字符：");
            if (scanner.hasNextLine()) {
                String input = scanner.nextLine();
                if (input.length() == 1) {
                    c = input.charAt(0);
                    break;
                } else {
                    System.out.println("输入有误，请重新输入。");
                }
            }
        }
        return c;
    }

    public static long  getLongInput(Scanner scanner,int length){
        long num;
        while (true){
            num=getLongInput(scanner);
            if ((int)(Math.log10(num)+1)==length){
                break;
            }else {
                System.out.println("输入位数限制为"+length+"位！请重新输入！");
            }
        }
        return num;
    }
    public static long getLongInput(Scanner scanner) {
        long num;
        while (true) {
            System.out.println("请输入一个长整数：");
            if (scanner.hasNextLong()) {
                num = scanner.nextLong();
                break;
            } else {
                System.out.println("输入有误，请重新输入。");
                scanner.next();
            }
        }
        return num;
    }

    public static float getFloatInput(Scanner scanner) {
        float num;
        while (true) {
            System.out.println("请输入一个浮点数：");
            if (scanner.hasNextFloat()) {
                num = scanner.nextFloat();
                break;
            } else {
                System.out.println("输入有误，请重新输入。");
                scanner.next(); // 清除错误的输入
            }
        }
        return num;
    }


    public static double getDoubleInput(Scanner scanner) {
        double num;
        while (true) {
            System.out.println("请输入一个双精度浮点数：");
            if (scanner.hasNextDouble()) {
                num = scanner.nextDouble();
                break;
            } else {
                System.out.println("输入有误，请重新输入。");
                scanner.next(); // 清除错误的输入
            }
        }
        return num;
    }

    public static String getStringInput(Scanner scanner,int length){
        String str;
        while (true){
            str=getStringInput(scanner);
            if (str.length()>length){
                System.out.println("字数限制为"+length+"字！请重新输入！");
            }else {
                break;
            }
        }
        return str;
    }
    public static String getStringInput(Scanner scanner) {
        String str;
        while (true) {
            System.out.println("请输入一个字符串：");
            if (scanner.hasNextLine()) {
                str=scanner.nextLine();
                break;
            }else {
                System.out.println("重新输入！");
            }
        }
        return str;
    }
}
