class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n=position.length;
        double[][] arr=new double[n][2];
        for(int i=0;i<n;i++){
            arr[i][0]=position[i];
            arr[i][1]=speed[i];
        }
        Arrays.sort(arr,(a,b)->Double.compare(a[0],b[0]));
        double[] time=new double[n];
        for(int i=0;i<n;i++) time[i]=(target-arr[i][0])/arr[i][1];
        double maxi=Double.MIN_VALUE;
        int ans=0;
        for(int i=n-1;i>=0;i--){
            if(time[i]>maxi){
                ans++;
                maxi=time[i];
            }
        }
        return ans;
    }
}
