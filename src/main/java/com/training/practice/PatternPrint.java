package com.training.practice;

import java.util.Scanner;

public class PatternPrint {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int t = scanner.nextInt();
            for (int i = 1; i <= t; i++) {
                int n = scanner.nextInt();
                getNumberPattern(n);
            }
        }
    }

    /*
    4444444
    4333334
    4322234
    4321234
    4322234
    4333334
    4444444
    */
    public static void getNumberPattern(int n) {
        // Write your code here.
        int count = 2 * n-1;
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < count; j++) {
                int right = 2 * (n - 1) - j;
                int bottom = 2 * (n - 1) - i;
                int num = n - Math.min(Math.min(i, j), Math.min(right, bottom));
                System.out.print(num);
            }
            System.out.println();
        }
    }

    /*
     *****  00,01,02,03,04
     *   *  10,11,12,13,14
     *   *  20,21,22,23,24
     *   *  30,31,32,33,34
     *****  40,41,42,43,44
     */
    public static void getStarPattern(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == n - 1 || i == 0 || j == 0 || j == n - 1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }


    /*

     *    *
     **  **
     ******
     **  **
     *    *

     */

    public static void symmetry2(int n) {
        for (int i = 1; i < 2 * n; i++) {
            int stars = i;
            if (i > n) {
                stars = 2 * n - i;
            }
            // stars
            for (int j = 1; j <= stars; j++) {
                System.out.print("*");
            }
            // spaces
            for (int j = 0; j < 2 * (n - stars); j++) {
                System.out.print(" ");
            }
            // stars
            for (int j = 1; j <= stars; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    /*
     ******
     **  **
     *    *
     *    *
     **  **
     ******
     */
    public static void symmetry(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                System.out.print("*");
            }
            for (int k = 0; k < 2 * i; k++) {
                System.out.print(" ");
            }
            for (int j = 0; j < n - i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }
            for (int k = 0; k < 2 * (n - i - 1); k++) {
                System.out.print(" ");
            }
            for (int l = i; l >= 0; l--) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    /*
        C
        C B
        C B A
    */
    public static void alphaTriangle(int n) {
        int a = n - 1;
        for (int i = 0; i < n; i++) {
            char c = 'A';
            c += a;
            for (int j = 0; j <= i; j++) {
                System.out.print(c-- + " ");
            }
            System.out.println();
        }
    }

    /*
            A
          A B A
        A B C B A
        */
    public static void alphaHill(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n - 1; j++) {
                System.out.print(" ");
            }
            char c = 'A';
            for (int j = 0; j <= i; j++) {
                System.out.print(c++);
            }
            c -= 2;
            for (int j = 0; j < i; j++) {
                System.out.print(c--);
            }
            System.out.println();
        }
    }

    /*
     A
     B B
     C C C
     D D D D
 */
    public static void alphaRamp(int n) {
        char c = 'A';
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(c + " ");
            }
            System.out.println();
            c++;
        }
    }

    /*
    A B C D
    A B C
    A B
    A
    * */
    public static void nLetterTriangleDesc(int n) {
        for (int i = 0; i < n; i++) {
            char c = 'A';
            for (int j = n; j > i; j--) {
                System.out.print(c++ + " ");
            }
            System.out.println();
        }
    }


    /*
    A
    A B
    A B C
    A B C D
    * */
    public static void nLetterTriangle(int n) {
        for (int i = 0; i < n; i++) {
            char c = 'A';
            for (int j = 0; j <= i; j++) {
                System.out.print(c++ + " ");
            }
            System.out.println();
        }
    }


    /*
    1
    2 3
    4 5 6
    7 8 9 10
    */

    public static void nIncreasingNumberTriangle(int n) {
        int count = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(count++ + " ");
            }
            System.out.println();
        }
    }

    /*
    *
    1         1
    1 2     2 1
    1 2 3 3 2 1
    *
    *
    *
    * 4 (n-0-1)*2
    * 2 (n-1-1)*2
    * 0 (3-2-1)*2
    1  1
    1221
* */

    public static void numberCrown(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(j + 1);
            }
            for (int k = 0; k < 2 * (n - i - 1); k++) {
                System.out.print(" ");
            }
            for (int l = i; l >= 0; l--) {
                System.out.print(l + 1);
            }
            System.out.println();
        }
    }

    /*
    1
    0 1
    1 0 1
    0 1 0 1
    * */
    public static void nBinaryTriangle(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if ((i + j) % 2 == 0) {
                    System.out.print(1 + " ");
                } else {
                    System.out.print(0 + " ");
                }
            }
            System.out.println();
        }
    }

    public static void leftTriangle(int n) {
        for (int i = 0; i < 2 * n; i++) {
            int stars = i;
            if (i > n) {
                stars = 2 * n - i;
            }
            for (int j = 0; j < stars; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void nStarTriangleReverse(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k < (n - i) * 2 - 1; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void nStarTriangle(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k < i * 2 + 1; k++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }

    public static void nNumberTriangle(int n) {
        // Write your code here
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i + 1; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    static void pattern1(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void seeding(int n) {
        // Write your code here
        for (int i = 1; i <= n; i++) {
            for (int j = n; j >= i; j--) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
