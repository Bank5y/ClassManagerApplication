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
        System.out.println("��ѡ��");
        for (int i = 0; i < options.size(); i++) {
            System.out.printf("%d. %s\n", i + 1, options.get(i));
        }
        System.out.println("0. �˳�");
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
                System.out.println("������Ч�����������룡");
            }
        } while (choice != 0);
        System.out.println("ллʹ�ã�");
    }
}
