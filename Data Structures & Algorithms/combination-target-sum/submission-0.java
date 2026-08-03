class Solution {

    private void dfs(int[] nums, int target, int i, List<Integer>li,
    List<List<Integer>>res){
        if(target==0){
            res.add(new ArrayList<>(li));
            return;
        } 
        if(i>=nums.length || target<0) return;

        li.add(nums[i]);
        dfs(nums,target-nums[i],i,li,res);

        li.remove(li.size()-1);
        dfs(nums,target,i+1,li,res);
    }

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>>res=new ArrayList<>();
        List<Integer>li=new ArrayList<>();

        dfs(nums,target,0,li,res);
        return res;
    }
}
