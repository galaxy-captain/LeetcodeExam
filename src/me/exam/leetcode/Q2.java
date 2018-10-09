package me.exam.leetcode;

import me.exam.leetcode.others.AbsQuestion;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Example:
 * <p>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */
public class Q2 implements AbsQuestion {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    @Override
    public void test() {
//        ListNode node1 = new ListNode(2);
//        node1.next = new ListNode(4);
//        node1.next.next = new ListNode(3);
//
//        ListNode node2 = new ListNode(5);
//        node2.next = new ListNode(6);
//        node2.next.next = new ListNode(4);

        ListNode node1 = new ListNode(9);

        ListNode node2 = new ListNode(1);
        node2.next = new ListNode(9);
        node2.next.next = new ListNode(9);
        node2.next.next.next = new ListNode(9);
        node2.next.next.next.next = new ListNode(9);
        node2.next.next.next.next.next = new ListNode(9);
        node2.next.next.next.next.next.next = new ListNode(9);
        node2.next.next.next.next.next.next.next = new ListNode(9);


        ListNode result = addTwoNumbers(node1, node2);

        while (result != null) {
            System.out.print(result.val + "->");
            result = result.next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int remainder = 0;

        ListNode result;

        int tmp = l1.val + l2.val + remainder;
        if (tmp > 9) {
            result = new ListNode(tmp % 10);
            remainder = 1;
        } else {
            result = new ListNode(tmp);
            remainder = 0;
        }

        ListNode node = result;
        l1 = l1.next;
        l2 = l2.next;

        while (true) {

            if (l1 == null && l2 == null)
                break;

            if (l1 == null) {
                tmp = l2.val + remainder;
                if (tmp > 9) {
                    node.next = new ListNode(tmp % 10);
                    remainder = 1;
                } else {
                    node.next = new ListNode(tmp);
                    remainder = 0;
                }
                l2 = l2.next;
                node = node.next;
            } else if (l2 == null) {
                tmp = l1.val + remainder;
                if (tmp > 9) {
                    node.next = new ListNode(tmp % 10);
                    remainder = 1;
                } else {
                    node.next = new ListNode(tmp);
                    remainder = 0;
                }
                l1 = l1.next;
                node = node.next;
            } else {

                tmp = l1.val + l2.val + remainder;
                if (tmp > 9) {
                    node.next = new ListNode(tmp % 10);
                    remainder = 1;
                } else {
                    node.next = new ListNode(tmp);
                    remainder = 0;
                }

                l1 = l1.next;
                l2 = l2.next;

                node = node.next;
            }

        }

        if(remainder == 1)
            node.next = new ListNode(1);

        return result;
    }


}
