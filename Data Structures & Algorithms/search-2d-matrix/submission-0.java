class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length;
        int n=matrix[0].length;

        int start_row=0;
        int start_col=0;
        int end_row=m-1;
        int end_col=n-1;

        int first_box=0;
        int last_box=m*n-1;

        while(first_box<=last_box){
            int mid_box=(first_box+last_box)/2;
            int mid_row=mid_box/n;
            int mid_col=mid_box%n;

            if(matrix[mid_row][mid_col]==target) return true;
            else if(matrix[mid_row][mid_col]>target) last_box=mid_box-1;
            else first_box=mid_box+1;
        }
        return false;
    }
}
