class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer>st=new Stack<>();
        for(int i=0;i<tokens.length;i++){
            if(tokens[i].equalsIgnoreCase("+") || tokens[i].equalsIgnoreCase("-") || tokens[i].equalsIgnoreCase("*") || tokens[i].equalsIgnoreCase("/")){
                int first=st.pop();
                int second=st.pop();
                if(tokens[i].equalsIgnoreCase("+")) st.push(first+second);
                if(tokens[i].equalsIgnoreCase("-")) st.push(second-first);
                if(tokens[i].equalsIgnoreCase("*")) st.push(first*second);
                if(tokens[i].equalsIgnoreCase("/")) st.push(second/first);
            }
            else{
                int num=Integer.parseInt(tokens[i]);
                st.push(num);
            }
        }
        return st.pop();
    }
}
