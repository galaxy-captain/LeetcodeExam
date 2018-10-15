package me.exam.leetcode;

import me.exam.leetcode.others.AbsQuestion;

public class Q8 implements AbsQuestion {

    @Override
    public void test() {
        System.out.println(myAtoi("0-1"));
    }

    public int myAtoi(String str) {

        boolean number = false;

        long num = 0;

        char[] sc = str.toCharArray();
        int p = 0;
        int offset = 0;

        while (sc[offset] == ' ') {
            if (++offset == sc.length) return 0;
        }

        while (sc[offset] == '0') {
            number = true;
            if (++offset == sc.length) return 0;
        }

        if (sc[offset] != '-') {
            if (sc[offset] == '+') offset++;
            else if (!(sc[offset] <= '9' && sc[offset] >= '0')) return 0;
        } else if (number) {
            return 0;
        } else {
            p = 1;
        }

        if (sc.length == offset) return 0;

        while (sc[offset] == '0') {
            if (++offset == sc.length) return 0;
        }

        for (int i = p + offset; i < sc.length && sc[i] <= '9' && sc[i] >= '0'; i++) {
            num = (num * 10 + (int) sc[i] - 48);
            if (num > Integer.MAX_VALUE)
                return p > 0 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }

        return (int) (p > 0 ? -num : num);
    }

}
