class Solution {

    private boolean palindrome(String s){
        String reversed=new StringBuilder(s).reverse().toString();
        return s.equals(reversed);
    }

    private void dfs(int ind,String s, List<String>li, List<List<String>>res){
        if(ind==s.length()){
            res.add(new ArrayList<>(li));
            return;
        }
        // create all the strings which start with index ind
        for(int i=ind;i<s.length();i++){
            String str=s.substring(ind,i+1);
            if(palindrome(str)){
                li.add(str);
                // next string will start from i+1
                dfs(i+1,s,li,res);
                li.remove(li.size()-1);
            }
        }
        
    }

    public List<List<String>> partition(String s) {
        List<List<String>>res=new ArrayList<>();
        List<String>li=new ArrayList<>();
        dfs(0,s,li,res);
        return res;
    }
}
