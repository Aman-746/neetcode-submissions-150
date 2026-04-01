class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        List<List<Integer>>res=new ArrayList<>();
        for(int i=0;i<n-2;i++){
            int left=i+1;
            int right=n-1;
            int rem=-1*nums[i];
            while(left<right){
                if(nums[left]+nums[right]==rem){
                    List<Integer>li=Arrays.asList(nums[i],nums[left],nums[right]);
                    if(!res.contains(li)) res.add(li);
                    left++;
                    right--;
                }
                else if(nums[left]+nums[right]>rem) right--;
                else left++;
            }
        }
        return res;
    }
}
