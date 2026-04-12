class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer>mp=new HashMap<>();
        for(int num:nums){
            mp.put(num,mp.getOrDefault(num,0)+1);
        }

        // occAsKey- occurrence as key
        Map<Integer,List<Integer>>occAsKey=new TreeMap<>((a,b)->b-a);
        for(int key:mp.keySet()){
            int val=mp.get(key);
            if(!occAsKey.containsKey(val)){
                occAsKey.put(val,new ArrayList<>(Arrays.asList(key)));
            }
            else{
                List<Integer>li=occAsKey.get(val);
                li.add(key);
            }
        }

        int[] res=new int[k];
        int cnt=0;
        for(int key:occAsKey.keySet()){
            for(Integer val:occAsKey.get(key)){
                res[cnt]=val;
                cnt++;

                if(cnt==k) break;
            }
            if(cnt==k) break;
        }
        return res;
    }
}
