package com.training.basics;

public class SumOfAllDivisors {

    public static void main(String[] args) {
        System.out.println(sumOfAllDivisors(5));
    }

    public static int sumOfAllDivisors(int n){
        // Write your code here.
        int sum = 0;
// for(int i=1; i<=n;i++){
//     sum+=divisiorsSum(i);
// }
        // int sum = 0;

        for (int i = 1; i <=n; i++) {
            int x = (n/i)*i;
            sum = sum+x;
        }
        // return sum;
        return sum;
    }
}
