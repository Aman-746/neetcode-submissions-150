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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0) return null;
        PriorityQueue<ListNode> minHeap=new PriorityQueue<>((a,b)->a.val-b.val);
        ListNode cur=new ListNode(0);
        ListNode res=cur;
        for(ListNode list:lists){
            if(list!=null) minHeap.offer(list);
        }
        while(!minHeap.isEmpty()){
            ListNode mini=minHeap.peek();
            cur.next=mini;
            cur=cur.next;

            minHeap.poll();
            mini=mini.next;
            if(mini!=null) minHeap.offer(mini);
        }
        return res.next;
    }
}
