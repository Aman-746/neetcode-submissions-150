class Solution {
    private void dfs(int[] nums, boolean[] picked, List<List<Integer>> res, List<Integer>li){
        if(li.size()==nums.length){
            res.add(new ArrayList<>(li));
            return;
        }

        for(int i=0;i<nums.length;i++){
            if(picked[i]!=true){
                li.add(nums[i]);
                picked[i]=true;
                dfs(nums,picked,res,li);
                picked[i]=false;
                li.remove(li.size()-1);
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        boolean[] picked = new boolean[nums.length];
        for(int i=0;i<nums.length;i++) picked[i]=false;
        List<List<Integer>> res=new ArrayList<>();
        List<Integer>li=new ArrayList<>();

        dfs(nums,picked,res,li);
        return res;
    }
}
