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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null && list2==null) return null;
        if(list1==null) return list2;
        if(list2==null) return list1;

        ListNode first=list1;
        ListNode second=list2;
        ListNode res=new ListNode();
        ListNode head=res;

        while(first!=null && second!=null){
            ListNode curNode=new ListNode();
            if(first.val<=second.val){
                curNode.val=first.val;
                first=first.next;
            } 
            else{
                curNode.val=second.val;
                second=second.next;
            }
            res.next=curNode;
            res=curNode;
        }

        if(first!=null) res.next=first;
        if(second!=null) res.next=second;

        return head.next;
    }
}