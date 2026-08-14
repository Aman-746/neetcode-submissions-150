class Solution {
    private void dfs(int i, List<List<Integer>>res, List<Integer>subset, int[] nums) {
        if(i>=nums.length){
            res.add(new ArrayList<>(subset));
            return;
        }

        // decision to include nums[i]
        subset.add(nums[i]);
        dfs(i+1, res, subset, nums);

        // not to include nums[i]
        subset.remove(subset.size()-1);
        dfs(i+1, res, subset, nums);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>>res= new ArrayList<>();
        List<Integer>subset=new ArrayList<>();
        dfs(0,res,subset,nums);
        return res;

    }
}
