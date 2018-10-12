package me.exam.leetcode;

import me.exam.leetcode.others.AbsQuestion;

import java.util.ArrayList;
import java.util.List;

public class Q7 implements AbsQuestion {

    @Override
    public void test() {
        System.out.println(reverse2(1534236469));
    }

    public int reverse2(int x) {

        if (x == 0) return 0;

        if (x == Integer.MAX_VALUE || x == Integer.MIN_VALUE) return 0;

        long nx = 0;

        for (; x != 0; x = x / 10) {
            int tmp = x % 10;
            if (tmp != 0 || x != 0)
                nx = nx * 10 + tmp;
        }

        return (nx > Integer.MAX_VALUE || nx < Integer.MIN_VALUE) ? 0 : (int) nx;
    }

    public int reverse(int x) {

        boolean offset = false;

        if (x < 0) {
            offset = true;
            x = -x;
        }

        List<Integer> list = new ArrayList<>();

        for (; x != 0; x = x / 10) {
            int tmp = x % 10;
            list.add(tmp);
        }

        for (int i = list.size() - 1, j = 0; i >= 0; i--) {
            if (list.get(i) > 0 || x > 0)
                x += list.get(i) * Math.pow(10, j++);
        }

        if (x == Integer.MAX_VALUE) return 0;

        return offset ? -x : x;
    }

}
