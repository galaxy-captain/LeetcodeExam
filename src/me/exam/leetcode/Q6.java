package me.exam.leetcode;

import me.exam.leetcode.others.AbsQuestion;

import java.util.ArrayList;
import java.util.List;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 * <p>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * <p>
 * Write the code that will take a string and make this conversion given a number of rows:
 * <p>
 * string convert(string s, int numRows);
 * Example 1:
 * <p>
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 * Example 2:
 * <p>
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:
 * <p>
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 */
public class Q6 implements AbsQuestion {

    @Override
    public void test() {
        String result = convert("PAYPALISHIRING", 3);
        System.out.println(result);
    }

    public String convert(String s, int numRows) {

        if (s == null || s.length() == 0 || numRows == 0) return "";

        StringBuffer result = new StringBuffer();
        List<char[]> list = new ArrayList<>();
        char[] tmp;
        int i = 0;

        while (i < s.length()) {

            tmp = new char[numRows];

            for (int j = 0; i < s.length() && j < numRows; i++) {
                tmp[j++] = s.charAt(i);
            }

            list.add(tmp);

            for (int k = 2; i < s.length() && k < numRows; k++) {
                tmp = new char[numRows];
                tmp[numRows - k] = s.charAt(i++);
                list.add(tmp);
            }

        }

        char[][] cq = new char[list.size()][numRows];

        for (i = 0; i < list.size(); i++) {
            cq[i] = list.get(i);
        }

        for (int y = 0; y < numRows; y++) {
            for (int x = 0; x < cq.length; x++) {
                if (cq[x][y] != '\u0000')
                    result.append(cq[x][y]);
            }
        }

        return result.toString();
    }

}
