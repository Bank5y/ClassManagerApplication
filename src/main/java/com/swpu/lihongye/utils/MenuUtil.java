package com.swpu.lihongye.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuUtil {
    private List<String> options;
    private List<Runnable> actions;

    public MenuUtil() {
        options = new ArrayList<>();
        actions = new ArrayList<>();
    }

    public void addOption(String name, Runnable action) {
        options.add(name);
        actions.add(action);
    }

    public void printMenu() {
        System.out.println("请选择：");
        for (int i = 0; i < options.size(); i++) {
            System.out.printf("%d. %s\n", i + 1, options.get(i));
        }
        System.out.println("0. 退出");
    }

    public void runMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            printMenu();
            System.out.print(">> ");
            choice = InputUtil.getIntInput(scanner);
            if (choice >= 1 && choice <= actions.size()) {
                actions.get(choice - 1).run();
            } else if (choice != 0) {
                System.out.println("输入无效，请重新输入！");
            }
        } while (choice != 0);
        System.out.println("谢谢使用！");
    }
}
