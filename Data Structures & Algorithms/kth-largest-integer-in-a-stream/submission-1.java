class KthLargest {
    PriorityQueue<Integer>pq=new PriorityQueue<>();
    int n=0;

    public KthLargest(int k, int[] nums) {
        n=k;
        for(int i:nums) pq.offer(i);
    }
    
    public int add(int val) {
        pq.offer(val);
        while(pq.size()>n){
            pq.poll();
        }
        return pq.peek();
    }
}
