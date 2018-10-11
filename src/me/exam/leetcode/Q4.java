package me.exam.leetcode;

import me.exam.leetcode.others.AbsQuestion;

import java.util.Arrays;

public class Q4 implements AbsQuestion {

    @Override
    public void test() {

        double median = findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4});

        System.out.println(median);

    }

    private double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] newArr = mergeArray(nums1, nums2);

        Arrays.sort(newArr);

        if (newArr.length % 2 == 0) {
            return (double) (newArr[newArr.length / 2] + newArr[newArr.length / 2 - 1]) / 2;
        } else {
            return newArr[newArr.length / 2];
        }
    }

    private int[] mergeArray(int[] nums1, int[] nums2) {

        int[] newArr = Arrays.copyOf(nums1, nums1.length + nums2.length);

        System.arraycopy(nums2, 0, newArr, nums1.length, nums2.length);

        return newArr;
    }

}
