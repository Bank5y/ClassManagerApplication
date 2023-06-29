package com.swpu.lihongye.test;

import com.swpu.lihongye.utils.InputUtil;

import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class TestUtils {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //3. 创建新Callable对象
        Callable<String> callable = new MyCallable();
        //4. 将Callable对象交给FutureTask对象
        /*
         作用
         1.实现Runnable接口方便交给Thread类处理
         2.可以在线程完成后通过get方法返回结果
         */
        FutureTask<String> futureTask = new FutureTask<>(callable);
        //5. 交给线程处理
        new Thread(futureTask).start();
        //接收结果
        String str = futureTask.get();
    }
}
//1. 定义任务类实现Callable接口
class MyCallable implements Callable<String> {
    //2. 重写call方法
    @Override
    public String call() throws Exception {
        return null;
    }
}
