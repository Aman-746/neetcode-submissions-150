class Solution {
    int res=0;

    private int dfs(int i, int j, int[][]grid){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j]==0) return 0;
        grid[i][j]=0;
        int area=1;
        area+=dfs(i,j-1,grid);
        area+=dfs(i-1,j,grid);
        area+=dfs(i,j+1,grid);
        area+=dfs(i+1,j,grid);
        return area;
    }

    public int maxAreaOfIsland(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int res=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    res=Math.max(res,dfs(i,j,grid));
                }
            }
        }
        return res;
    }
}
