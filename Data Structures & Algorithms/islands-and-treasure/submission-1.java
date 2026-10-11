class Solution {
    private int INF=2147483647;
    public void islandsAndTreasure(int[][] grid) {
        // multisource bfs

        Queue<int[]>q=new LinkedList<>();
        int m=grid.length;
        int n=grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0) q.add(new int[]{i,j});
            }
        }

        if(q.size()==0) return;
        while(!q.isEmpty()){
            int[] node=q.poll();
            int row=node[0];
            int col=node[1];

            // GO LEFT
            if(col-1>=0 && grid[row][col-1]==INF){
                grid[row][col-1]=grid[row][col]+1;
                q.add(new int[]{row,col-1});
            }
            // GO TOP
            if(row-1>=0 && grid[row-1][col]==INF){
                grid[row-1][col]=grid[row][col]+1;
                q.add(new int[]{row-1,col});
            }
            // GO RIGHT
            if(col+1<n && grid[row][col+1]==INF){
                grid[row][col+1]=grid[row][col]+1;
                q.add(new int[]{row,col+1});
            }
            // GO BOTTOM
            if(row+1<m && grid[row+1][col]==INF){
                grid[row+1][col]=grid[row][col]+1;
                q.add(new int[]{row+1,col});
            }
        }
    }
}
