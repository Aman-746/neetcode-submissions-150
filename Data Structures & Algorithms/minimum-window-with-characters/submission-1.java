class Solution {
    public String minWindow(String s, String t) {
        // s=ouzodyyxazv
        // t=xyz
        if(s.length()<t.length()) return "";
        Map<Character,Integer>t_map=new HashMap<>();
        Map<Character,Integer>s_map=new HashMap<>();
        for(char c:t.toCharArray()){
            t_map.put(c,t_map.getOrDefault(c,0)+1);
        }

        int low=0;
        int high=0;
        while(high<s.length()){
            char c=s.charAt(high);
            if(!t_map.containsKey(c)){
                high++;
                low++;
            }
            else break;
        }

        int cnt=0;
        int ans=Integer.MAX_VALUE;
        int res_low=-1;
        int res_high=-1;

        while(high<s.length()){
            char c=s.charAt(high);
            if(t_map.containsKey(c)){
                s_map.put(c,s_map.getOrDefault(c,0)+1);
                if(s_map.get(c)>t_map.get(c)) cnt++;
            }
            else{
                cnt++;
            }
            
            while(high-low+1-cnt==t.length()){
                if(high-low+1<ans){
                    ans=high-low+1;
                    res_low=low;
                    res_high=high;
                }
                if(s_map.containsKey(s.charAt(low))){
                    if(s_map.get(s.charAt(low))>t_map.get(s.charAt(low))){
                        s_map.put(s.charAt(low),s_map.get(s.charAt(low))-1);
                        cnt--;
                    }
                    else if(s_map.get(s.charAt(low))==t_map.get(s.charAt(low))){
                        s_map.put(s.charAt(low),s_map.get(s.charAt(low))-1);
                        if(s_map.get(s.charAt(low))==0) s_map.remove(s.charAt(low));
                    }
                }
                else if(!t_map.containsKey(s.charAt(low))) cnt--;
                low++;
            }

            high++;
        }
        if(res_low==-1 && res_high==-1) return "";
        String res=s.substring(res_low,res_high+1);
        return res;
    }
}
