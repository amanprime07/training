package com.training.binarySearch.arrays1d;

import java.util.Arrays;

public class FloorAndCiel {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5, 7};
        System.out.println(Arrays.toString(getFloorAndCeil(arr, arr.length, 6)));
        System.out.println(Arrays.toString(getFloorAndCeil(arr, arr.length, 5)));
    }

    public static int[] getFloorAndCeil(int[] arr, int n, int x) {
        // Write your code here.
        int floor = -1;
        int ceil = -1;

        int left = 0;
        int right = n-1;
        while(left <= right){
            int mid = (left+right)/2;
            if(arr[mid]<= x){
                floor = mid;
                left = mid+1;
            }
            if(arr[mid]>=x){
                ceil = mid;
                right = mid-1;
            }
        }

        return new int[]{arr[floor], arr[ceil]};

    }
}
