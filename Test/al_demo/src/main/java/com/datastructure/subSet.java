package com.datastructure;

import jdk.nashorn.internal.ir.CallNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class subSet {
    public static void main(String[] args) {
        List<List<Integer>> sub = sub(new int[]{2, 6, 1, 5, 6, 9,});
        System.out.println(sub.toString());
    }

    public static List<List<Integer>> sub(int[] nums){
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> item = new ArrayList<Integer>();
        if(nums.length == 0 || nums == null){
            return res ;
        }
        //排序
        Arrays.sort(nums);
        dfs(nums,0,item,res);
        res.add(new ArrayList<Integer>());

        return res;
    }
    public static void dfs(int[] nums,int start,List<Integer> item,List<List<Integer>> res){
        for (int i = start;i<nums.length;i++){
            item.add(nums[i]);
            res.add(new ArrayList<Integer>(item));
            dfs(nums,i+1,item,res);
            item.remove(item.size()-1);
        }
    }
}
