class Solution {
    public int findKthLargest(int[] nums, int k) {
        // we will use quick selection algorithm
        // 1,5,6,3,2,4

        k=nums.length-k;
        return quickSelect(nums,0,nums.length-1,k);
    }

    private int quickSelect(int[] nums, int left, int right, int k){
        int pivot=nums[right];
        int p=left;

        for(int i=left;i<right;i++){
            // if nums[i] less than equal to pivot then swap nums[i]
            // and nums[p], p will always point to the index where all
            // the left values will be smaller than pivot
            if(nums[i]<=pivot){
                int temp=nums[p];
                nums[p]=nums[i];
                nums[i]=temp;
                p++;
            }
        }

        // now swap pivot or nums[right] and nums[p]
        int temp=nums[p];
        nums[p]=nums[right];
        nums[right]=temp;

        // now it became - 1,3,2,4,6,5
        // left of pivot is smaller or equal to pivot and right of pivot
        // is larger than pivot

        // do the quick select in left half
        if(k<p) return quickSelect(nums,left,p-1,k);

        // do the quick select in right half
        else if(k>p) return quickSelect(nums,p+1,right,k);

        // it's the pivot index itself
        else return nums[p];
    }
}
