package me.longDay.LeetCode;

/**
 * @author 君
 * @version 1.0
 * @desc TODO
 * @since 2022-10-27
 */
public class Utils {
    public static void swap(int[] arr,int a,int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
