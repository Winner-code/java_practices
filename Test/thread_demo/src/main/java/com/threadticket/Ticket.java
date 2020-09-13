package com.threadticket;

public class Ticket implements Runnable{
    private int ticket = 5;
    @Override
    public void run() {
        for (int i=0;i<100;i++){
            if (ticket>0){
                System.out.println(Thread.currentThread().getName()+"正在出售第"+(ticket--)+"张票");
            }
        }
    }
}
