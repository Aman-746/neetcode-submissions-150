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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int total=0;
        ListNode temp=head;

        while(temp!=null){
            total++;
            temp=temp.next;
        }

        // means I need to remove (total-n+1)th node
        if(total==n) return head.next;
        temp=head;
        ListNode prev=null;
        int cnt=0;
        while(cnt!=total-n){
            cnt++;
            prev=temp;
            temp=temp.next;
        }
        prev.next=temp.next;
        return head;
    }
}
