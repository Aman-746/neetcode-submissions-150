class Solution {
    public int maxArea(int[] heights) {
        int left=0;
        int right=heights.length-1;
        int ans=Integer.MIN_VALUE;
        while(left<right){
            ans=Math.max(ans,(right-left)*Math.min(heights[left],heights[right]));
            if(heights[left]<heights[right]) left++;
            else if(heights[left]>heights[right]) right--;
            else{
                left++;
                right--;
            }
        }
        return ans;
    }
}
