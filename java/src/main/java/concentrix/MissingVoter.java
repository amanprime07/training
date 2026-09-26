package concentrix;

import java.util.Scanner;

public class MissingVoter {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            sc.nextLine();
            long[] arr1 = new long[n];
            long[] arr2 = new long[n - 1];
            for (int i = 0; i < n; i++) {
                arr1[i] = sc.nextLong();
            }
            for (int i = 0; i < n - 1; i++) {
                arr2[i] = sc.nextLong();
            }
            System.out.println(missingVoter(arr1, arr2));
        }
    }

    private static long missingVoter(long[] arr1, long[] arr2) {
        long missingVoter = 0;
        for (int i = 0; i < arr2.length; i++) {
            missingVoter ^= arr1[i];
            missingVoter ^= arr2[i];
        }
        missingVoter = missingVoter ^ arr1[arr1.length - 1];
        return missingVoter;
    }
}
