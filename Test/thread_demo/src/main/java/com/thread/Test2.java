package com.thread;

public class Test2 {
    public static void main(String[] args) {
        MyThread2 myThread2 = new MyThread2();
        myThread2.start();
        for (int i=0 ;i<10;i++){
            System.out.println("MyThread2------"+i);
        }
    }
}
