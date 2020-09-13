package com.threadticket;

public class Test {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        Thread t1 = new Thread(ticket,"A窗口");
        Thread t2 = new Thread(ticket,"B窗口");
        Thread t3 = new Thread(ticket,"C窗口");

        t1.start();
        t2.start();
        t3.start();
    }
}
