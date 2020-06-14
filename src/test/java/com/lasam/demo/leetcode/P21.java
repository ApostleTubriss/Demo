package com.lasam.demo.leetcode;

/**
 * @author liuhao
 * @date 2020/6/10 23:42
 */
public class P21 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode result = null;
        ListNode last = null;
        while (true) {
            if (l1 == null) {
                last.next = l2;
                break;
            }
            if (l2 == null) {
                last.next = l1;
                break;
            }
            if (l1.val <= l2.val) {
                if (result == null) {
                    result = l1;
                    last = result;
                } else {
                    last.next = l1;
                    last = last.next;
                }
                l1 = l1.next;

            } else {
                if (result == null) {
                    result = l2;
                    last = result;
                } else {
                    last.next = l2;
                    last = last.next;
                }
                l2 = l2.next;
            }

        }

        return result;
    }
}
