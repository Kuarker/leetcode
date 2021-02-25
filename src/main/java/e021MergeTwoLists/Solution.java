package e021MergeTwoLists;

/**
 * @description:
 * @author: Kuarker Lee
 * @date: 2021/2/14
 **/
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode first=head;
        ListNode listNode1=l1;
        ListNode listNode2=l2;
        while(listNode1!=null&&listNode2!=null ){

            if (listNode1.val<listNode2.val){
                ListNode temp=new ListNode(listNode1.val,null);
                listNode1=listNode1.next;
                first.next=temp;
                first=first.next;
            }else {
                ListNode temp=new ListNode(listNode2.val,null);
                listNode2=listNode2.next;
                first.next=temp;
                first=first.next;
            }

        }
        while(listNode1!=null){
            ListNode temp=new ListNode(listNode1.val,null);
            listNode1=listNode1.next;
            first.next=temp;
            first=first.next;

        }
        while(listNode2!=null){
            ListNode temp=new ListNode(listNode2.val,null);
            listNode2=listNode2.next;
            first.next=temp;
            first=first.next;
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
