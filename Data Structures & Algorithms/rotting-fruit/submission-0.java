class Solution {
    public int orangesRotting(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        Queue<int[]>q=new LinkedList<>();

        int totalFresh=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1) totalFresh++;
                if(grid[i][j]==2) q.add(new int[]{i,j});
            }
        }

        int[][] dirs={{1,0},{-1,0},{0,1},{0,-1}};
        int min=0;
        int cnt=0;

        while(!q.isEmpty()){
            int size=q.size();
            min++;
            boolean flg=false;

            while(size!=0){
                int[] node=q.poll();
                int row=node[0];
                int col=node[1];

                for(int[] dir:dirs){
                    int adjRow=dir[0]+row;
                    int adjCol=dir[1]+col;
                    if(adjRow<0 || adjRow>=m || adjCol<0 || adjCol>=n || grid[adjRow][adjCol]==0) continue;

                    if(grid[adjRow][adjCol]==1){
                        flg=true;
                        cnt++;
                        grid[adjRow][adjCol]=2;
                        q.add(new int[]{adjRow,adjCol});
                    } 
                }
                size--;
            }
            if(flg==false) min--;
        }

        if(cnt==totalFresh) return min;
        return -1;
    }
}
