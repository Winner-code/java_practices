package com.runnable;

public class MyRunnable implements Runnable{
    public void run() {
        for(int i=0;i<10;i++){
            System.out.println("MyRunnable.run()---->"+i);
        }
    }
}
