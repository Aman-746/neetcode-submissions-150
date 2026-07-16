class Solution {
    public int[][] kClosest(int[][] points, int k) {
        
        PriorityQueue<double[]>pq=new PriorityQueue<>((a,b)->Double.compare(a[0],b[0]));
        for(int i=0;i<points.length;i++){
            int x=points[i][0];
            int y=points[i][1];
            double root=Math.sqrt(x*x+y*y);
            double[] data=new double[2];
            data[0]=root;
            data[1]=i;
            pq.offer(data);
        }

        int[][] ans=new int[k][];
        int i=0;
        while(k!=0){
            double[] data=pq.poll();
            int ind=(int) data[1];
            ans[i++]=points[ind];
            k--;
        }
        return ans;
    }
}
