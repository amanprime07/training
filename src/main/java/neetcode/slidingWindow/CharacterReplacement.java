package neetcode.slidingWindow;

public class CharacterReplacement {

    public static void main(String[] args) {
        String s = "AABABBBCCC";
        int k = 1;
        System.out.println(characterReplacement(s, k));
        String s1 = "EOEMQLLQTRQDDCOERARHGAAARRBKCCMFTDAQOLOKARBIJBISTGNKBQGKKTALSQNFSABASNOPBMMGDIOETPTDICRBOMBAAHINTFLH";
        System.out.println(characterReplacement(s1, 7));
    }

    private static int characterReplacement(String s, int k) {
        int l = 0, maxWindow = 0, w = 0, max =0;
        int[] count = new int[26];
        for (int r = 0; r < s.length(); r++) {
            int ri = s.charAt(r) - 'A';
            count[ri] += 1;
            max = Math.max(max, count[ri]);
            while (r - l + 1 - max > k) {
                int li = s.charAt(l) - 'A';
                count[li] -= 1;
                l++;
            }
            w = r - l + 1;
            if (maxWindow < w) {
                maxWindow = w;
            }
        }
        return maxWindow;

    }

    private static int max(int[] arr) {
        int max = 0;
        for (int i : arr) {
            if (max < i) {
                max = i;
            }
        }
        return max;
    }
}
