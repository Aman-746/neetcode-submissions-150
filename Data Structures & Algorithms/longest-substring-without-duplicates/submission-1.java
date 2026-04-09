class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character>st=new HashSet<>();
        int low=0;
        int high=0;
        int res=0;
        while(high<s.length()){
            if(st.contains(s.charAt(high))){
                while(s.charAt(low)!=s.charAt(high)){
                    st.remove(s.charAt(low));
                    low++;
                } 
                // if(s.charAt(low)==s.charAt(high)){
                    st.remove(s.charAt(low));
                    low++;
                // }
            }
            else{
                st.add(s.charAt(high));
                res=Math.max(res,high-low+1);
                high++;
            } 
        }
        return res;
    }
}
