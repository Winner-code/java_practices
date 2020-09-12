package com.al;

/**
 * 插入排序--从小到大排序
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] sort = sort(new int[]{12, 1, 2, 25, 68, 45, 36, 99});
        for(int n = 0;n<sort.length;n++){
            System.out.println(sort[n]);
        }
    }
    public static int[] sort(int[] arr){
        //从第二个数开始插入
        for(int i = 1;i<arr.length;i++){
            int val = arr[i];
            //被插入的位置
            int index = i-1;
            //比较两个值，后面的值<前面的值
            while(index>=0 && val<arr[index]){
                arr[index+1] = arr[index--];
            }
            arr[index+1] = val;
        }
        return arr;
    }
    public static void sort2(Comparable[] arr){
        for(int i = 1;i<arr.length;i++){
            for(int j = i;j>0 &&(arr[j].compareTo(arr[j-1])<0);j--){
                Comparable temp = arr[j];
                arr[j] = arr[j-1];
                arr[j] = temp;
            }
        }
    }
}
