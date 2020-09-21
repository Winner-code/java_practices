package com.inuput;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String s1 = scanner.nextLine();
        String[] s2 = s1.split(" ");
        System.out.println(s);
        System.out.println(s1);
        for(int i=0;i<s2.length;i++){
            System.out.println(s2[i]);
        }
    }
}
