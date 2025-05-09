package neetcode.arraysHashing;

import java.util.Arrays;

public class ProductExceptSelf {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4};
        System.out.println(Arrays.toString(productExceptSelf(arr))); //[24,12,8,6]

        arr = new int[]{-1,1,0,-3,3};
        System.out.println(Arrays.toString(productExceptSelf(arr))); //[0,0,9,0,0]
    }

    private static int[] productExceptSelf(int[] arr) {
        int[] ans = new int[arr.length];
        Arrays.fill(ans, 1);
        int curr = 1;
        for (int i = 0; i < arr.length; i++) {
            ans[i] = ans[i] * curr;
            curr = curr * arr[i];
        }
        curr = 1;

        for (int i = arr.length - 1; i >= 0; i--) {
            ans[i] = ans[i] * curr;
            curr = curr * arr[i];
        }
        return ans;
    }
}
