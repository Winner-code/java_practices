package com.threadticket2;

public class Test2 {
    public static void main(String[] args) {
        Ticket2 ticket2 = new Ticket2();
        Thread t11 = new Thread(ticket2,"AA窗口");
        Thread t22= new Thread(ticket2,"BB窗口");
        Thread t33 = new Thread(ticket2,"CC窗口");

        t11.start();
        t22.start();
        t33.start();
    }
}
