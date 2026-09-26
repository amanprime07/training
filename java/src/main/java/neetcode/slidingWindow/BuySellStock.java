package neetcode.slidingWindow;

public class BuySellStock {

    public static void main(String[] args) {
        int[] prices = new int[]{10, 1, 5, 6, 7, 1};
        int r = buySellStock(prices);
        System.out.println(r);

        prices = new int[]{10,8,7,5,2};
        r = buySellStock(prices);
        System.out.println(r);

    }

    private static int buySellStock(int[] arr) {
        int maxProfit = Integer.MIN_VALUE;
        int profit = 0;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }

            profit = arr[i] - min;
            if (profit > maxProfit) {
                maxProfit = profit;
            }
        }
        return maxProfit;
    }
}
