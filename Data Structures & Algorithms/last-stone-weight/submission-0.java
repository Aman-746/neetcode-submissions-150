class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer>pq=new PriorityQueue<>((a,b)->b-a);

        for(int i:stones) pq.offer(i);
        while(pq.size()>1){
            int first=pq.peek();
            pq.poll();
            int second=pq.peek();
            pq.poll();
            int remain=Math.abs(first-second);
            if(remain>0) pq.offer(remain);
        }
        if(pq.size()==1) return pq.peek();
        return 0;
    }
}
