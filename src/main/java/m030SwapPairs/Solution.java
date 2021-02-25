package m030SwapPairs;

/**
 * @description:https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 * @author: Kuarker Lee
 * @date: 2021/2/14
 * 总结： 链表遍历 head=head.next ,链表修改 head.next=null,遍历不会影响链表，修改会影响链表值
 **/
public class Solution {

    public static void main(String[] args) {

        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2, listNode1);
        ListNode listNode3 = new ListNode(3, listNode2);
        ListNode listNode4 = new ListNode(4, listNode3);
        ListNode listNode5 = new ListNode(5, listNode4);
        ListNode listNode6 = new ListNode(6, listNode5);
        ListNode listNode = swapPairs2(listNode6);

    }

    public static ListNode swapPairs(ListNode head) {
        // 终止条件
        if (head == null || head.next == null) {
            return head;
        }
        // first 一定不为null
        ListNode first = head;
        ListNode second = first.next;
        ListNode third = second.next;
        // 第二个元素的next指向第一个
        second.next = first;
        // 传入第三个元素，并将函数的返回值赋值给已变为第二的first
        first.next = swapPairs(third);
        // 返回交换成榜首的第二个元素，所以不会影响之前的操作
        return second;


    }

    public static ListNode swapPairs2(ListNode head) {
        if (head==null||head.next==null){
            return head;
        }
        ListNode temp = head;
        ListNode dummy = head.next;
        ListNode temp2 = dummy;
        boolean flag=false;
        while (temp != null && temp.next != null) {

            ListNode first = temp;
            ListNode second = temp.next;
            ListNode third = second.next;
            temp = temp.next.next;
            second.next = first;
            first.next = third;
            if (flag){
                // 第一次时不需要交换
                // 快慢指针
                temp2.next.next=second;
                temp2=temp2.next.next;
            }
            flag=true;
        }
        return dummy;

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
