class Solution {
    public int search(int[] nums, int target) {
        // 1st approach
        // find the index of minimum value, this is the point where rotation
        // has happened

        int n=nums.length;
        int left=0;
        int right=n-1;
        while(left<right){
            int mid=left+(right-left)/2;
            if(nums[mid]>nums[right]) left=mid+1;
            else right=mid;
        }
        int start=0;
        int end=0;
        if(left==0){
            end=n-1;
        }
        else if(target>=nums[0] && target<=nums[left-1]){
            // means target is in left sorted array
            start=0;
            end=left-1;
        }
        else if(target>=nums[left] && target<=nums[n-1]){
            // means target is in right sorted array
            start=left;
            end=n-1;
        }
        else return -1;

        while(start<=end){
            int mid=(start+end)/2;
            if(target==nums[mid]) return mid;
            else if(target<nums[mid]) end=mid-1;
            else start=mid+1;
        }

        return -1;
    }
}
