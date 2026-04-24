class Solution {
    public int trap(int[] height) {
        // in previous solution, we created two array
        // first one to store the maximum bar height in left
        // second one to store the maximum bar height in right
        // then took the minimum of both the maximum
        // space complexity - O(n)

        // in this solution we won't store value in array
        // instead we will use left and right pointer.
        // we will move the pointer away where 
        // bar height will be less because we only need the 
        // minimum of leftMax and rightMax so whenever we will
        // move pointer to right, we will update leftMax
        // and whenever we will move pointer to left, we will update
        // rightMax

        int n=height.length;
        int l=0;
        int r=n-1;
        int maxLeft=0;
        int maxRight=0;
        int res=0;
        while(l<r){
            if(height[l]<=height[r]){
                if(maxLeft-height[l]>0) res+=maxLeft-height[l];
                maxLeft=Math.max(height[l],maxLeft);
                l++;
            }
            else{
                if(maxRight-height[r]>0) res+=maxRight-height[r];
                maxRight=Math.max(height[r],maxRight);
                r--;
            }
        }
        return res;
    }
}
