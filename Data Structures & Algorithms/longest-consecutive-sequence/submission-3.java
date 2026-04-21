class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0) return 0;
        Set<Integer>st=new HashSet<>();
        for(int num:nums) st.add(num);
        int maxLength=1;
        for(Integer num:st){
            // if nums-1 is not present means it will be the lowest
            // number of the group
            if(!st.contains(num-1)){
                int length=1;
                while(st.contains(num+length)){
                    length++;
                    maxLength=Math.max(maxLength,length);
                }
            }
        }
        return maxLength;
    }
}
