class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer>pq=new PriorityQueue<>((a,b)->b-a);
        for(int i:nums) pq.offer(i);
        int res=-1;
        while(k!=0){
            res=pq.poll();
            k--;
        }
        return res;
    }
}
