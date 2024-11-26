package concentrix;

import java.util.Scanner;

public class Overlap {

    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {
         int n = 4;
         int[]arr = new int[n];
         for(int i=0; i<n; i++){
             arr[i] = sc.nextInt();
         }
            System.out.println(overlap(arr));
        }
    }
//    L1, R1, L2, R2
    private static String overlap(int[]arr){
        if(arr[0]<=arr[3] && arr[2]<=arr[1]){
            return "YES";
        }
        return "NO";
    }
}
