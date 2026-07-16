class Solution {
    public int[][] kClosest(int[][] points, int k) {
        
        PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));
        for(int i=0;i<points.length;i++){
            int x=points[i][0];
            int y=points[i][1];
            int sqr=(x*x+y*y);
            // int[] data=new int[2];
            // data[0]=root; // will keep the square
            // data[1]=i; // will keep the index
            pq.offer(new int[]{sqr,i});
        }

        int[][] ans=new int[k][];
        int i=0;
        while(i<k){
            int[] data=pq.poll();
            int ind=data[1];
            ans[i++]=points[ind];
        }
        return ans;
    }
}
