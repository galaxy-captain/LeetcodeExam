package me.exam.leetcode;

import me.exam.leetcode.others.AbsQuestion;

import java.util.Arrays;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Example:
 *
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
public class Q1 implements AbsQuestion {

    @Override
    public void test() {
        Q1 q1 = new Q1();
        int[] result = q1.twoSum(new int[]{2, 7, 11, 15},9);
        System.out.println(Arrays.toString(result));
    }

    private int[] twoSum(int[] nums, int target) {

        for(int i = 0;i<nums.length;i++){

            for(int j = i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target)
                    return new int[]{i,j};
            }

        }

        return null;
    }

}
