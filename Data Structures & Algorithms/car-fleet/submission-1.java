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
        for(int i=0;i<n;i++){
            time[i]=(target-arr[i][0])/arr[i][1];
        }
        int ans=1;
        Stack<Double> st=new Stack<>();
        st.push(time[n-1]);
        for(int i=n-2;i>=0;i--){
            if(time[i]>st.peek()) st.push(time[i]);
        }
        return st.size();
    }
}

// Car which is behind is reaching faster to destination than
// car ahead means they will meet at some point and make
// a fleet
