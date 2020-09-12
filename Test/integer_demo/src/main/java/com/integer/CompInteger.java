package com.integer;

public class CompInteger {
    public static void main(String[] args) {
        Integer integer1 = new Integer(1);
        Integer integer2 = new Integer(1);
        System.out.println(integer1==integer2);
        System.out.println(integer1.equals(integer2));

        System.out.println("---------------------------");

        int integer3 = 1;
        Integer integer4 = new Integer(1);
        System.out.println(integer3=integer4);

        System.out.println("---------------------------");

        int integer5 = 0;
        Integer integer6 = null;
        System.out.println(integer5=integer6);

    }
}
