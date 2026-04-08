class Solution {
    public int maxProfit(int[] prices) {
        int res=0;
        int n=prices.length;
        int[] maxInRight=new int[n];
        maxInRight[n-1]=prices[n-1];
        int maxi=0;
        for(int i=n-2;i>=0;i--){
            maxInRight[i]=Math.max(prices[i],maxInRight[i+1]);
        }
        for(int i=0;i<n;i++) res=Math.max(res,maxInRight[i]-prices[i]);
        return res;
    }
}
