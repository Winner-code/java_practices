package com.al;

/**
 * 二分查找--折半查找
 */
public class BiSearch {
    public static void main(String[] args) {
        int i = biSearch(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11}, 6);
        System.out.println(i);

    }
    public static int biSearch(int [] array,int a){
        int low = 0;
        int high = array.length-1;
        int mid;
        while(low<=high){
            //确定中空间位置
            mid = (low+high)/2;
            if(array[mid]==a){
                return mid + 1;
            }else if(array[mid] < a){
                //向右查找
                low = mid +1 ;
            }else{
                //向左查找
                high = mid - 1;
            }
        }
        return -1;
    }
}
