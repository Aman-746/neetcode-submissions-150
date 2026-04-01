class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer>map=new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        // 1,1,1,2,2,3,4
        // map: 1-3, 2-2, 3-1, 4-1
        Map<Integer,List<Integer>>tm=new TreeMap<>((a,b)->b-a);
        for(Integer key:map.keySet()){
            if(tm.containsKey(map.get(key))){
                List<Integer>li=tm.get(map.get(key));
                li.add(key);
            }
            else{
                tm.put(map.get(key),new ArrayList<>(Arrays.asList(key)));
            }
        }

        // tm: 3-1, 2-2, 1-{3,4}
        // three times 1, two times 2, one time 3 & 4

        int[] ans=new int[k];
        int cnt=0;
        for(Integer key:tm.keySet()){
            for(int i=0;i<tm.get(key).size();i++){
                if(cnt==k) break;
                ans[cnt]=tm.get(key).get(i);
                cnt++;
            }
            if(cnt==k) break;
        }
        return ans;
    }
}
