class MinStack {
    private Stack<Integer>st;

    public MinStack() {
        st=new Stack<>();
    }
    
    public void push(int val) {
        st.push(val);
    }
    
    public void pop() {
        st.pop();
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        Stack<Integer>temp=new Stack<>();
        int mini=Integer.MAX_VALUE;
        while(!st.empty()){
            int top=st.pop();
            mini=Math.min(mini,top);
            temp.push(top);
        }
        while(!temp.empty()){
            int top=temp.pop();
            st.push(top);
        }
        return mini;
    }
}
