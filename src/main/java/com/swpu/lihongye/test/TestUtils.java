package com.swpu.lihongye.test;

import com.swpu.lihongye.utils.InputUtil;

import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class TestUtils {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //3. ������Callable����
        Callable<String> callable = new MyCallable();
        //4. ��Callable���󽻸�FutureTask����
        /*
         ����
         1.ʵ��Runnable�ӿڷ��㽻��Thread�ദ��
         2.�������߳���ɺ�ͨ��get�������ؽ��
         */
        FutureTask<String> futureTask = new FutureTask<>(callable);
        //5. �����̴߳���
        new Thread(futureTask).start();
        //���ս��
        String str = futureTask.get();
    }
}
//1. ����������ʵ��Callable�ӿ�
class MyCallable implements Callable<String> {
    //2. ��дcall����
    @Override
    public String call() throws Exception {
        return null;
    }
}
