class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // remember
        // if you want next greater element then use
        // monotonic decreasing stack
        // and if you want next smaller element then use
        // monotonic increasing stack

        int n=temperatures.length;
        int res[]=new int[n];
        Stack<Integer>st=new Stack<>();
        for(int i=0;i<n;i++){
            if(st.empty() || temperatures[st.peek()]>=temperatures[i]) st.push(i);
            else{
                while(!st.empty() && temperatures[st.peek()]<temperatures[i]){
                    int ind=st.pop();
                    res[ind]=i-ind;
                }
                st.push(i);
            }
        }
        return res;
    }
}
