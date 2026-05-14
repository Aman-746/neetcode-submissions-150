/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public void reorderList(ListNode head) {
        ListNode temp=head;
        int totalNode=0;
        while(temp!=null){
            totalNode++;
            temp=temp.next;
        }
        temp=head;
        int halfway=0;
        while(halfway!=totalNode/2){
            temp=temp.next;
            halfway++;
        }
        // now we will reverse the linkedlist after halfway 

        ListNode prev=null;
        ListNode cur=temp.next;
        temp.next=null;
        ListNode next=null;

        while(cur!=null){
            next=cur.next;
            cur.next=prev;
            prev=cur;
            cur=next;
        }

        // now prev will point to the last node
        temp=head;
        while(temp!=null && prev!=null){
            ListNode temp_next=temp.next;
            ListNode prev_next=prev.next;
            temp.next=prev;
            prev.next=temp_next;
            temp=temp_next;
            prev=prev_next;
        }
    }
}
