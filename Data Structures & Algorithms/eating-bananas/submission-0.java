class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int mini=1;
        int maxi=Integer.MIN_VALUE;
        for(int i=0;i<piles.length;i++){
            maxi=Math.max(maxi,piles[i]);
        }
        // now i'll search for answer between mini and maxi
        int res=0;
        while(mini<=maxi){
            int mid=(mini)+(maxi-mini)/2;
            int time=0;
            for(int i=0;i<piles.length;i++){
                if(piles[i]%mid==0) time+=(piles[i]/mid);
                else time+=(piles[i]/mid+1);
            }
            if(time<=h){
                maxi=mid-1;
                res=mid;
            } 
            else mini=mid+1;
        }
        return res;
    }
}
