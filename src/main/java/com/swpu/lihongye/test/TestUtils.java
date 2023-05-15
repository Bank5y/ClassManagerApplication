package com.swpu.lihongye.test;

import com.swpu.lihongye.utils.InputUtil;

import java.util.Scanner;

public class TestUtils {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        long num=InputUtil.getLongInput(scanner,5);
        System.out.println(num);
    }
}
