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
        // we will do it recursively like we do for merge sort

        // divide into two parts
        // left and right
        // again break left into left and right
        // break right into left and right

        // once each node is apart from each other
        // we will merge and pass it above

        // bottom to up approach
        // at last we will get the merged linked list

        int n=lists.length;

        if(lists==null || lists.length==0) return null;
        return divide(lists,0,n-1);
    }

    private ListNode divide(ListNode[] lists, int l, int r){
        if(l>r) return null;
        if(l==r) return lists[l];

        int mid=l+(r-l)/2;

        ListNode left=divide(lists,l,mid);
        ListNode right=divide(lists,mid+1,r);

        return merge(left,right);
    }

    private ListNode merge(ListNode l1, ListNode l2){
        ListNode dummy=new ListNode(0);
        ListNode curr=dummy;

        while(l1!=null && l2!=null){
            if(l1.val<=l2.val){
                curr.next=l1;
                l1=l1.next;
            } else{
                curr.next=l2;
                l2=l2.next;
            }

            curr=curr.next;
        }

        if(l1!=null) curr.next=l1;
        else curr.next=l2;

        return dummy.next;
    }
}
