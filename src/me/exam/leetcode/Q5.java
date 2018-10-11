package me.exam.leetcode;

import me.exam.leetcode.others.AbsQuestion;

import java.util.Arrays;

public class Q5 implements AbsQuestion {

    @Override
    public void test() {
        String result = longestPalindrome("babad");
        System.out.println(result);
    }

    public String longestPalindrome(String s) {

        if (s == null) return null;

        if (s.length() == 1) return s;

        String maxPalindromicStr = "";

        char[] cs = s.toCharArray();

        for (int i = 0; i < cs.length; i++) {

            int a = i;
            int b = i;

            while (a >= 0 && b < cs.length) {

                if (cs[a] == cs[b]) {

                    if (b - a + 1 >= maxPalindromicStr.length()) {
                        maxPalindromicStr = new String(Arrays.copyOfRange(cs, a, b + 1));
                    }

                    a--;
                    b++;
                } else {
                    break;
                }

            }

        }

        for (int i = 0; i < cs.length - 1; i++) {

            if (cs[i] != cs[i + 1]) continue;

            int a = i;
            int b = i + 1;

            while (a >= 0 && b < cs.length) {

                if (cs[a] == cs[b]) {

                    if (b - a + 1 >= maxPalindromicStr.length()) {
                        maxPalindromicStr = new String(Arrays.copyOfRange(cs, a, b + 1));
                    }

                    a--;
                    b++;
                } else {
                    break;
                }

            }

        }

        return maxPalindromicStr;
    }

}
