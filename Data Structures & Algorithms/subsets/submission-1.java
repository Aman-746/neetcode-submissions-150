class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        // using bit manipulation

        int n=nums.length;
        List<List<Integer>>res=new ArrayList<>();
        for(int i=0;i<(1<<n);i++){
            List<Integer>li=new ArrayList<>();
            for(int j=n-1;j>=0;j--){
                if((i&(1<<j))!=0) li.add(nums[j]);
            }
            res.add(li);
        }
        return res;
    }
}

// i=7 (101)
// j=0  
//.     100
