class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>>res=new ArrayList<>();
        
        Map<String,List<String>>mp=new HashMap<>();
        for(String str:strs){
            // create a char array
            int[] charArr=new int[26];
            for(char c:str.toCharArray()){
                charArr[c-'a']++;
            }
            String strArr=Arrays.toString(charArr);
            if(mp.containsKey(strArr)){
                List<String>li=mp.get(strArr);
                li.add(str);
            }
            else{
                mp.put(strArr,new ArrayList<>(Arrays.asList(str)));
            }
        }

        for(String key:mp.keySet()){
            res.add(mp.get(key));
        }

        return res;
    }
}
