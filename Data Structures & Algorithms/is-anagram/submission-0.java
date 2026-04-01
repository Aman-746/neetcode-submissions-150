class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character,Integer>mp1=new HashMap<>();
        for(char ch:s.toCharArray()){
            if(mp1.containsKey(ch)){
                mp1.put(ch,mp1.get(ch)+1);
            } else {
                mp1.put(ch,1);
            }
        }

        Map<Character,Integer>mp2=new HashMap<>();
        for(char ch:t.toCharArray()){
            if(mp2.containsKey(ch)){
                mp2.put(ch,mp2.get(ch)+1);
            } else {
                mp2.put(ch,1);
            }
        }

        return mp1.equals(mp2);
    }
}
