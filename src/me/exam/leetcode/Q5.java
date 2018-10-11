package me.exam.leetcode;

import me.exam.leetcode.others.AbsQuestion;

import java.util.Arrays;

public class Q5 implements AbsQuestion {

    @Override
    public void test() {
        String result = longestPalindrome2("babad");
        System.out.println(result);
    }

    public String longestPalindrome2(String s) {

        if (s == null || s.length() == 0) return "";

        int length = 0;
        int start = 0;
        int end = 0;

        char[] cs = s.toCharArray();

        for (int i = 0; i < cs.length; i++) {

            int a = i;
            int b = i;

            while (a >= 0 && b < cs.length) {

                if (cs[a] == cs[b]) {

                    if (b - a + 1 >= length) {
                        start = a;
                        end = b + 1;
                        length = b - a + 1;
                    }

                    a--;
                    b++;
                } else {
                    break;
                }

            }

            if (i == cs.length - 1) continue;

            if (cs[i] == cs[i + 1]) {
                int a2 = i;
                int b2 = i + 1;

                while (a2 >= 0 && b2 < cs.length) {

                    if (cs[a2] == cs[b2]) {

                        if (b2 - a2 + 1 >= length) {
                            start = a2;
                            end = b2 + 1;
                            length = b2 - a2 + 1;
                        }

                        a2--;
                        b2++;
                    } else {
                        break;
                    }

                }
            }

        }

        return new String(Arrays.copyOfRange(cs, start, end));
    }



        public String longestPalindrome(String s) {

            if (s == null || s.length() == 0) return "";

            int length = 0;
            int start = 0;
            int end = 0;

            char[] cs = s.toCharArray();

            for (int i = 0; i < cs.length; i++) {

                int a = i;
                int b = i;

                while (a >= 0 && b < cs.length) {

                    if (cs[a] == cs[b]) {

                        if (b - a + 1 >= length) {
                            start = a;
                            end = b + 1;
                            length = b - a + 1;
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

                        if (b - a + 1 >= length) {
                            start = a;
                            end = b + 1;
                            length = b - a + 1;
                        }

                        a--;
                        b++;
                    } else {
                        break;
                    }

                }

            }

            return new String(Arrays.copyOfRange(cs, start, end));
        }

}
