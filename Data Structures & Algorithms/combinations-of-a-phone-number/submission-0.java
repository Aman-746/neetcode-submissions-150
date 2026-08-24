class Solution {

    private void dfs(int ind, List<String>req, List<String>res, StringBuilder sb){
        if(ind==req.size()){
            res.add(sb.toString());
            return;
        }
        for(int j=0;j<req.get(ind).length();j++){
            sb.append(req.get(ind).charAt(j));
            dfs(ind+1,req,res,sb);
            sb.deleteCharAt(sb.length()-1);
        }
        
    }

    public List<String> letterCombinations(String digits) {
List<String>mapping=Arrays.asList("abc","def","ghi","jkl","mno","pqrs","tuv","wxyz");
        List<String>req=new ArrayList<>();
        if(digits.length()==0) return req;
        for(int i=0;i<digits.length();i++){
            req.add(mapping.get(digits.charAt(i)-'2'));
        }
        List<String>res=new ArrayList<>();
        StringBuilder sb=new StringBuilder();
        dfs(0,req,res,sb);
        return res;
    }
}
