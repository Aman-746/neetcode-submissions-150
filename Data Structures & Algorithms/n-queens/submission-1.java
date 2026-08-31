class Solution {

    private boolean safe(int i, int j, int n, List<String>li, int[] arr){
        if(li.isEmpty()) return true;
        // these three routes i will check
        // ↖ ↑ ↗
        
        int curRow=i-1;
        int curCol=j-1;
        while(curRow>=0 && curCol>=0){
            if(arr[curRow--]==curCol--) return false;
        }

        curRow=i-1;
        curCol=j;
        while(curRow>=0){
            if(arr[curRow--]==curCol) return false;
        }

        curRow=i-1;
        curCol=j+1;
        while(curRow>=0 && curCol<n){
            if(arr[curRow--]==curCol++) return false;
        }

        return true;
    }

    private void dfs(int i, int n,List<String>li,List<List<String>>res, int[] arr){
        if(li.size()==n){
            res.add(new ArrayList<>(li));
            return;
        }
        for(int j=0;j<n;j++){
            if(safe(i,j,n,li,arr)){
                // placed queen at (i,j)
                arr[i]=j;
                StringBuffer sb=new StringBuffer();
                for(int k=0;k<j;k++) sb.append(".");
                sb.append("Q");
                for(int k=j+1;k<n;k++) sb.append(".");

                li.add(sb.toString());
                dfs(i+1,n,li,res,arr);
                li.remove(li.size()-1);
                arr[i]=-1;
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>>res=new ArrayList<>();
        List<String>li=new ArrayList<>();
        int[] arr=new int[n];
        Arrays.fill(arr,-1);
        dfs(0,n,li,res,arr); // starting with row 0
        return res;
    }
}
