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
    public ListNode merge(ListNode prev, ListNode cur){
        ListNode head = prev.val<=cur.val ? prev:cur;
        ListNode oneBack=null;
        while(prev!=null && cur!=null){
            while(prev!=null && prev.val<=cur.val){
                oneBack=prev;
                prev=prev.next;
            }
            if(prev==null) break;
            ListNode target=cur;
            // insert target node between oneBack and prev
            if(oneBack!=null) oneBack.next=target;
            cur=cur.next;
            target.next=prev;
            oneBack=target;
        }
        if(cur!=null) oneBack.next=cur;
        return head;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        int len=lists.length;
        if(len==0) return null;
        ListNode prev=lists[0];
        for(int i=1;i<len;i++){
            ListNode cur=lists[i];
            // merge prev and cur lists
            prev = merge(prev,cur);
        }
        return prev;
    }
}
