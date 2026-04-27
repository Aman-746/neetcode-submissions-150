class Solution {
    public boolean isValid(String s) {
        Stack<Character>st=new Stack<>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c=='(' || c=='{' || c=='[') st.push(c);
            else{
                if(st.empty()) return false;
                if(c==')'){
                    char top=st.pop();
                    if(top!='(') return false;
                }
                else if(c=='}'){
                    char top=st.pop();
                    if(top!='{') return false;
                }
                else{
                    char top=st.pop();
                    if(top!='[') return false;
                }
            }
        }
        if(!st.empty()) return false;
        return true;
    }
}
