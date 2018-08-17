package com.training.string;


import java.time.LocalDate;
public class Solution {

    public static void main(String[] args) {

//        Scanner sc = new Scanner(System.in);
//        String A = sc.next();
//        String b = "";
//        /* Enter your code here. Print output to STDOUT. */
//        for (int i = A.length() - 1; i >= 0; i--) {
//            b = b.concat(String.valueOf(A.charAt(i)));
//        }
//        System.out.println(b);
//        if (b.equals(A)) {
//            System.out.println("Yes");
//        } else {
//            System.out.println("No");
//        }

        System.out.println(isAnagram("abc", "cba"));
    }

    static boolean isAnagram(String a, String b) {
        // Complete the function
        int[] arr = new int[Character.MAX_VALUE];
        if (a.length() != b.length())
            return false;
//        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < a.length(); i++) {
            arr[a.charAt(i)]++;
        }
        for (int i = 0; i < b.length(); i++) {
            int count = arr[(a.charAt(i))];
            if (count <= 0)
                return false;
            arr[a.charAt(i)]--;
        }
        return true;
    }

    private String getDay(String day, String month, String year){
        LocalDate date = LocalDate.of(Integer.valueOf(year), Integer.valueOf(month), Integer.valueOf(day) );
        return date.getDayOfWeek().name();
    }
}



