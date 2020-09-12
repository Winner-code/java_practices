package com.al;

/**
 * 冒泡排序
 * 比较相邻数据，将大的数据交换到后面
 */
public class BubbleSearch {
    public static void main(String[] args) {
        int[] ints = bubbleSort(new int[]{12, 1, 2, 25, 68, 45, 36, 99});
        for(int n=0;n<ints.length;n++){
            System.out.println(ints[n]);
        }
    }
    public static int[] bubbleSort(int [] arr){
        for(int i = 0;i<arr.length-1 ; i++){
            for (int j = 0;j<arr.length-1-i;j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }

        }
        return arr;
    }
}
