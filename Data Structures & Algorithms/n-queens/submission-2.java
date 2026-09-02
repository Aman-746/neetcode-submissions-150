class Solution {

    private boolean safe(int i, int j, Set<Integer>cols, Set<Integer>negDiag, Set<Integer>posDiag){
        // these three routes i will check
        // ↖ ↑ ↗
        
        if(cols.contains(j)) return false;
        if(negDiag.contains(i-j)) return false;
        if(posDiag.contains(i+j)) return false;
        return true;
    }

    private void dfs(int i, int n,List<String>li,List<List<String>>res, Set<Integer>cols, Set<Integer>negDiag, Set<Integer>posDiag){
        if(li.size()==n){
            res.add(new ArrayList<>(li));
            return;
        }
        for(int j=0;j<n;j++){
            if(safe(i,j,cols,negDiag,posDiag)){
                // placed queen at (i,j)
                cols.add(j);
                negDiag.add(i-j);
                posDiag.add(i+j);

                StringBuffer sb=new StringBuffer();
                for(int k=0;k<j;k++) sb.append(".");
                sb.append("Q");
                for(int k=j+1;k<n;k++) sb.append(".");

                li.add(sb.toString());
                dfs(i+1,n,li,res,cols,negDiag,posDiag);
                li.remove(li.size()-1);
                cols.remove(j);
                negDiag.remove(i-j);
                posDiag.remove(i+j);
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>>res=new ArrayList<>();
        List<String>li=new ArrayList<>();
        Set<Integer>cols=new HashSet<>();
        Set<Integer>negDiag=new HashSet<>();
        Set<Integer>posDiag=new HashSet<>();
        dfs(0,n,li,res,cols,negDiag,posDiag); // starting with row 0
        return res;
    }
}
