class Solution {
    public int search(int[] nums, int target) {
        // in this solution
        // we will check if mid is in left portion or
        // in right portion
        // 4,5,6,7,0,1,2

        int left=0;
        int right=nums.length-1;
        while(left<=right){
            int mid=(left+right)/2;
            if(target==nums[mid]) return mid;

            if(nums[mid]>nums[right]){
                // means mid is in left sorted array
                if(target>nums[mid]) left=mid+1;
                else{
                    if(target>=nums[left]) right=mid-1;
                    else left=mid+1;
                }
            }
            else{
                // means mid is in right sorted array
                if(target<nums[mid]) right=mid-1;
                else{
                    if(target<=nums[right]) left=mid+1;
                    else right=mid-1;
                }
            } 
        }
        return -1;
    }
}
