package m002AddTwoNumbers;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {



    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode head = new ListNode(0);
        ListNode cur = head;
        int temp = 0;
        while (l1 != null || l2 != null || temp != 0) {
            int sum = temp;
            if (l1 != null) {
                sum += l1.val;
            }
            if (l2 != null) {
                sum += l2.val;
            }
            temp = sum / 10;
            if (l1 != null) {
                l1 = l2.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
        }
        return head.next;


    }

    class ListNode {
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