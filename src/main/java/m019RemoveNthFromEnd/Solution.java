package m019RemoveNthFromEnd;

/**
 * @description:
 * @author: Kuarker Lee
 * @date: 2021/2/14
 **/
public class Solution {

    public static void main(String[] args) {

        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
//        ListNode listNode2 = new ListNode(2);
//        ListNode listNode3 = new ListNode(3);
//        ListNode listNode4 = new ListNode(4);
//        ListNode listNode5 = new ListNode(5);
//        ListNode listNode6 = new ListNode(6);
        listNode.next = listNode1;
//        listNode1.next = listNode2;
//        listNode2.next = listNode3;
//        listNode3.next = listNode4;
//        listNode4.next = listNode5;
//        listNode5.next = listNode6;


        ListNode listNode7 = removeNthFromEnd(listNode, 2);


    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode first = head;
        int count = n;
        while (first != null&&count>0 ) {
            first = first.next;
            count--;
        }
        // n 大于链表元素
        if (count >0) {
            return head;
        }
        // n 等于链表元素
        if (first==null){
            return head.next;
        }

        ListNode temp = head;
        while (first != null) {
            // 快指针到达末端
            if (first.next == null) {
                temp.next = temp.next.next;
                break;
            }
            first = first.next;
            temp = temp.next;
        }
        return head;


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


