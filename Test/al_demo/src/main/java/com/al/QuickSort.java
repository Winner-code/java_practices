package com.al;

/**
 * 快速排序
 * 选择第一个元素作为基准值，小的放在左右，大的放在右侧
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {10,7,2,4,7,62,3,4,2,1,8,9,19};
        sort(arr, 0, arr.length-1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+"\t");
        }

    }
    public static void sort(int[] arr,int low ,int high){
        int i,j,temp,t;
        if(low>high){
            return;
        }
        i=low;
        j=high;
        //temp就是基准位
        temp = arr[low];

        while (i<j) {
            //先看右边，依次往左递减--大于基准值就左移
            while (temp<=arr[j]&&i<j) {
                j--;
            }
            //再看左边，依次往右递增--小于基准值就右移3
            while (temp>=arr[i]&&i<j) {
                i++;
            }
            //如果满足条件则交换
            if (i<j) {
                t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;
            }

        }
        //最后将基准为与i和j相等位置的数字交换
        arr[low] = arr[i];
        arr[i] = temp;
        //递归调用左半数组
        sort(arr, low, j-1);
        //递归调用右半数组
        sort(arr, j+1, high);
    }
}