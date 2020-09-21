package com.datastructure;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ListSet {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("1");
        list.add("2");
        list.add("2");
        list.add("3");
        list.add("3");
        list.add("4");
        list.add("4");
        list.add("5");
        list.add("5");
        list.add("6");
        System.out.println(list);

        HashSet<String> s = new HashSet<String>();
        for (int i=0;i<list.size();i++){
            s.add(list.get(i));
        }
        System.out.println(s);
    }
}
