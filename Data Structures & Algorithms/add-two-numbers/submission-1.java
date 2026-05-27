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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // reverse both the linked list

        ListNode l1_head=l1;
        ListNode l2_head=l2;

        ListNode prev=new ListNode();
        int carry=0;
        boolean flag=true;

        ListNode ans=null;
        while(l1_head!=null && l2_head!=null){
            ListNode res=new ListNode();
            res.val=(l1_head.val+l2_head.val+carry)%10;
            carry=(l1_head.val+l2_head.val+carry)/10;
            prev.next=res;
            prev=res;
            if(flag){
                ans=prev;
                flag=false;
            }
            l1_head=l1_head.next;
            l2_head=l2_head.next;
        }

        while(l1_head!=null){
            ListNode res=new ListNode();
            res.val=(l1_head.val+carry)%10;
            carry=(l1_head.val+carry)/10;
            prev.next=res;
            prev=res;
            l1_head=l1_head.next;
        }

        while(l2_head!=null){
            ListNode res=new ListNode();
            res.val=(l2_head.val+carry)%10;
            carry=(l2_head.val+carry)/10;
            prev.next=res;
            prev=res;
            l2_head=l2_head.next;
        }

        if(carry>0){
            ListNode res=new ListNode();
            res.val=carry;
            prev.next=res;
            prev=res;
        }

        return ans;
    }
}
