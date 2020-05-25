package com.lasam.demo.leetcode;

public class P25 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return val + String.valueOf(next);
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode end = dummy;
        while (end != null) {
            // 让 end 遍历到需要翻转的最后一个元素位置
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            // 只要 end 遍历到了 null 直接跳出循环
            if (end == null) {
                break;
            }
            // 定义 pLast 指向翻转元素后面第一个元素
            ListNode pLast = end.next;
            // 定义 start 指向翻转元素的第一个位置
            ListNode start = pre.next;
            // 最后一个翻转元素先断链
            end.next = null;
            // 然后通过翻转方法 reverse() 后接在 pre 后面
            pre.next = reverse(start);

            // 保持下次循环一致的位置
            start.next = pLast;
            pre = start;
            end = pre;
        }
        return dummy.next;
    }

    private ListNode reverse(ListNode start) {
        ListNode pre = null;
        ListNode cur = start;
        while (cur != null) {
            ListNode p = cur.next;
            cur.next = pre;
            pre = cur;
            cur = p;
        }
        return pre;
    }

}
