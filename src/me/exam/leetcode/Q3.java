package me.exam.leetcode;

import me.exam.leetcode.others.AbsQuestion;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 * <p>
 * Example 1:
 * <p>
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 * <p>
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 * <p>
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class Q3 implements AbsQuestion {

    @Override
    public void test() {
        System.out.println(lengthOf("abba"));
    }

    public int lengthOf(String s) {

        if (s == null || s.length() == 0) return 0;

        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        int l = 0;

        for (int r = 0; r < s.length(); r++) {

            char cr = s.charAt(r);

            if (map.containsKey(cr) && map.get(cr) >= l) {
                l = map.get(cr) + 1;
            }

            map.put(cr, r);
            max = Math.max(max, r - l + 1);
        }

        return max;
    }

    public int lengthOfLongestSubstring(String s) {

        int maxLength = 0;

        int length = 0;

        char[] sc = s.toCharArray();
        char[] tc = new char[sc.length];

        for (int i = 0; i < sc.length; i++) {

            int index = isContain(sc[i], tc, length);

            if (index == -1) {
                tc[length++] = sc[i];
            } else {

                if (length > maxLength)
                    maxLength = length;

                tc = moveArr(index, tc);
                length -= (index + 1);
                tc[length++] = sc[i];

            }

        }

        if (length > maxLength)
            maxLength = length;

        return maxLength;
    }

    private int isContain(char target, char[] arr, int length) {
        for (int i = 0; i < length; i++)
            if (arr[i] == target)
                return i;
        return -1;
    }

    private char[] moveArr(int index, char[] arr) {
        for (int i = 0, j = index + 1; i < arr.length && j < arr.length; i++, j++) {
            arr[i] = arr[j];
        }
        return arr;
    }

}
