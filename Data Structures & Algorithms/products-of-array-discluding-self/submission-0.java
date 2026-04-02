class Solution {
    public int[] productExceptSelf(int[] nums) {
        int prod=1;
        int zero=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0) zero++;
            else prod*=nums[i];
        }
        int[] res=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                if(zero==1) res[i]=prod;
                else if(zero>1) res[i]=0;
            }
            else{
                if(zero>=1) res[i]=0;
                else{
                    res[i]=prod/nums[i];
                }
            }
        }
        return res;
    }
}  
