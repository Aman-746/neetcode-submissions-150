class Solution {

    private void dfs(StringBuffer sb, List<String>res, int openLeft, int closeLeft){
        if(openLeft==0 && closeLeft==0){
            res.add(sb.toString());
            return;
        }
        if(openLeft<0 || openLeft>closeLeft){
            return;
        } 
        sb.append('(');
        dfs(sb,res,openLeft-1,closeLeft);
        sb.deleteCharAt(sb.length()-1);
        sb.append(')');
        dfs(sb,res,openLeft,closeLeft-1);
        sb.deleteCharAt(sb.length()-1);
    }

    public List<String> generateParenthesis(int n) {
        List<String>res=new ArrayList<>();
        // if n=3 then i have 3 ((( and 3 )))

        int openLeft=n;
        int closeLeft=n;
        StringBuffer sb=new StringBuffer("");
        dfs(sb,res,openLeft,closeLeft);

        return res;

    }
}
