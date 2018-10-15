package me.exam.leetcode;

import me.exam.leetcode.others.AbsQuestion;

public class Q9 implements AbsQuestion {

    @Override
    public void test() {
        System.out.println(isPalindrome(12321));
    }

    public boolean isPalindrome(int x) {

        if (x < 0) return false;

        if (x < 10) return true;

        int size = 0;
        int tmp = x;

        while (tmp > 0) {
            tmp /= 10;
            size++;
        }

        int xa = x;
        int xb = x;

        for (int i = 0, j = size - 1; i < size && j >= 0 && i < j; i++, j--) {

            int b = (int) (xb / Math.pow(10, j));
            xb = (int) (xb % Math.pow(10, j));
            double a = xa % 10;
            xa = xa / 10;

            if (a != b)
                return false;
        }

        return true;
    }

}
