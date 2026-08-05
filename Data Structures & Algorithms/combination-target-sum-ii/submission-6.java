class Solution {

    private void dfs(int[] candidates, int i, int target, List<Integer> li, List<List<Integer>> res){
        if(target==0){
            if(!res.contains(li)) res.add(new ArrayList<>(li));
            return;
        }
        if(i>=candidates.length || target<0) return;

        // selecting ith element
        li.add(candidates[i]);
        dfs(candidates,i+1,target-candidates[i],li,res);

        // removing ith element
        li.remove(li.size()-1);
        while(i+1<candidates.length && candidates[i]==candidates[i+1]) i++;
        dfs(candidates,i+1,target,li,res);
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> li=new ArrayList<>();
        dfs(candidates,0,target,li,res);
        return new ArrayList<>(res);
    }
}
