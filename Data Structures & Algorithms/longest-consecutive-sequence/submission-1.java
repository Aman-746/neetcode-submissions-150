class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0) return 0;
        List<Integer>li=new ArrayList<>();
        Set<Integer>st=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(!st.contains(nums[i])){
                st.add(nums[i]);
                li.add(nums[i]);
            }
        }
        Collections.sort(li);
        int ans=1;
        int maxAns=1;
        for(int i=1;i<li.size();i++){
            if(li.get(i)==li.get(i-1)+1){
                ans++;
                maxAns=Math.max(ans,maxAns);
            }
            else ans=1;
        }
        return maxAns;
    }
}
