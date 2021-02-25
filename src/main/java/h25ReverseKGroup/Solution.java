package h25ReverseKGroup;

/**
 * @description: https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
 * @author: Kuarker Lee
 * @date: 2021/2/15
 **/
public class Solution {

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2, listNode1);
        ListNode listNode3 = new ListNode(3, listNode2);
        ListNode listNode4 = new ListNode(4, listNode3);
        ListNode listNode5 = new ListNode(5, listNode4);
        ListNode listNode6 = new ListNode(6, listNode5);
        ListNode listNode = reverseKGroup(listNode6, 3);
    }

    public static ListNode reverseKGroup(ListNode head, int k) {


        ListNode tail = head;

        for (int i = 0; i < k; i++) {
            if (tail == null) {
                return head;
            }
            tail = tail.next;
        }

        ListNode newHead = reverse2(head, k);
        // head.next 在reverse(head,tail)函数来交换后，已经变为原来的tail元素了
        head.next = reverseKGroup(tail, k);

        // 递归调用
        return newHead;

    }
    static ListNode reverse2(ListNode head,int k) {
        ListNode pre = null;
        ListNode next = null;
        int count=0;
        while (count<k) {
            // 取出下一个元素
            next = head.next;
            // 第二轮的head是第一轮的next，
            // 第二轮的pre是上一轮的head元素,
            head.next = pre;
            // 将head赋给pre
            pre = head;
            // head 原来的next 赋给head，迭代使用
            head = next;
            count++;
        }
        return pre;

    }
    static ListNode reverse(ListNode head, ListNode tail) {
        ListNode pre = null;
        ListNode next = null;
        while (head != tail) {
            // 取出下一个元素
            next = head.next;
            // 第二轮的head是第一轮的next，
            // 第二轮的pre是上一轮的head元素,
            head.next = pre;
            // 将head赋给pre
            pre = head;
            // head 原来的next 赋给head，迭代使用
            head = next;
        }
        return pre;

    }

    static class ListNode {
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
}
