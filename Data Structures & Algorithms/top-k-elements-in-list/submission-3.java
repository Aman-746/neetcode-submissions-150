class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // we will use bucket sort
        // time complexity will be o(n)
        // for e.g. nums=[1,1,1,2,2,3,3,100]
        // 1-3,2-2,3-2,100-1
        // we will create a bucket array such that it's index
        // will tell us the count and value will tell that which
        // element is coming that no of times

        Map<Integer,Integer>mp=new HashMap<>();
        for(int num:nums){
            mp.put(num,mp.getOrDefault(num,0)+1);
        }

        int n=nums.length;
        List<List<Integer>>li=new ArrayList<>();
        for(int i=0;i<=n;i++){
            li.add(new ArrayList<>());
        }

        for(int key:mp.keySet()){
            int val=mp.get(key);
            li.get(val).add(key);
        }

        int[] res=new int[k];
        int cnt=0;
        for(int i=n;i>0;i--){
            for(int elem:li.get(i)){
                res[cnt]=elem;
                cnt++;

                if(cnt==k) break;
            }
            if(cnt==k) break;
        }

        return res;

    }
}
