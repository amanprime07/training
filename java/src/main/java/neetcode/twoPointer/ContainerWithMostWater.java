package neetcode.twoPointer;

public class ContainerWithMostWater {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(arr));
        arr = new int[]{1, 1};
        System.out.println(maxArea(arr));
    }

    private static int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int maxArea = 0;
        while (l < r) {
            int min = Math.min(height[l], height[r]);
            maxArea = Math.max(maxArea, min * (r - l));
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return maxArea;
    }
}
