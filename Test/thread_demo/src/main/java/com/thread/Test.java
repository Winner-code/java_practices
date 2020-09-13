package com.thread;

public class Test {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
        myThread.run();
        System.out.println("MyThread执行完成----");
    }
}
