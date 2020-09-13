package com.threadticket2;

public class Ticket implements Runnable{
    private int ticket = 5;
    @Override
    public void run() {
        for (int i=0;i<100;i++){
            synchronized (this){
                if (ticket>0){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"正在出售第"+(ticket--)+"张票");
                }
            }
        }
    }
}
