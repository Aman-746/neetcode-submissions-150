class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character,Integer>s1_map=new HashMap<>();
        Map<Character,Integer>s2_map=new HashMap<>();
        for(char c:s1.toCharArray()){
            s1_map.put(c,s1_map.getOrDefault(c,0)+1);
        }
        // s1=aabc
        // s2=lecacbae
        int low=0;
        int high=0;
        while(high<s2.length()){
            char c=s2.charAt(high);

            if(!s1_map.containsKey(c)){
                high++;
                while(low!=high){
                    if(s1_map.containsKey(s2.charAt(low))){
                        s2_map.put(s2.charAt(low),s2_map.get(s2.charAt(low))-1);
                        if(s2_map.get(s2.charAt(low))==0) s2_map.remove(s2.charAt(low));
                    }
                    low++;
                }
            } 
            else{
                s2_map.put(c,s2_map.getOrDefault(c,0)+1);
                while(s2_map.get(c)>s1_map.get(c)){
                    s2_map.put(s2.charAt(low), s2_map.get(s2.charAt(low))-1);
                    low++;
                }
                if(high-low+1==s1.length()) return true;
                high++;
            }
        }
        return false;
    }
}
