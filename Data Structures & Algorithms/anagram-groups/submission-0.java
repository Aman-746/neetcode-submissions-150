class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>>map=new HashMap<>();

        for(String str:strs){
            int[] arr=new int[26];
            
            for(int i=0;i<str.length();i++){
                arr[str.charAt(i)-'a']++;
            }

            String strArr=Arrays.toString(arr);
            if(map.containsKey(strArr)){
                List<String>li=map.get(strArr);
                li.add(str);
            }

            else map.put(strArr,new ArrayList<>(Arrays.asList(str)));
        }

        List<List<String>>ans=new ArrayList<>();
        for(String key:map.keySet()){
            ans.add(map.get(key));
        }

        return ans;
    }
}

// 1. Create a count array for each string
// 2. Put this array as key and that string as value in a map
// 3. Before putting array in map, convert it into string because
//    when you will compare it with same array it will return false
// 4. If string of array is already present then simply take the 
//    value and append the current string.
// 5. Else add that string into list as a value.
// 6. Create a list of list and add value one by one and return


