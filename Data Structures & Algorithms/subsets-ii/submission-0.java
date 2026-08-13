class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        int n=nums.length;
        Set<List<Integer>>set=new HashSet<>();
        for(int mask=0;mask<(1<<n);mask++){
            List<Integer>subset=new ArrayList<>();
            for(int i=0;i<n;i++){
                if((mask & (1<<i))!=0) subset.add(nums[i]);
            }
            Collections.sort(subset);
            set.add(subset);
        }
        List<List<Integer>>res=new ArrayList<>(set);
        return res;
    }
}
