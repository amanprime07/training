package com.striver79;

public class PeakElement {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1};
        System.out.println(arr[peakElement(arr)]);
    }

    private static int peakElement(int[] nums) {
        int size = nums.length;
        if (size == 1 || nums[0] > nums[1]) {
            return 0;
        }
        if (nums[size - 1] > nums[size - 2]) {
            return size - 1;
        }

        int left = 1;
        int right = size - 2;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid - 1] < nums[mid] && nums[mid] > nums[mid + 1]) {
                return mid;
            }

            if (nums[mid - 1] < nums[mid]) {
                // ascending order
                left = mid + 1;
            } else {
                // descending order
                right = mid - 1;
            }
        }

        return -1;
    }
}
