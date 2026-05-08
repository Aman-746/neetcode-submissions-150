class Solution {
    public int search(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(target==nums[mid]) return mid;

            if(nums[mid]>=nums[left]){
                // means mid is in left sorted array
                if(target>nums[mid]) left=mid+1;
                else{
                    if(target>=nums[left]) right=mid-1;
                    else left=mid+1;
                }
            }
            else{
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