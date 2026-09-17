public class TrieNode{
    TrieNode[] children=new TrieNode[26];
    boolean endOfWord=false;
}

class Solution {

    TrieNode root=new TrieNode();
    List<String>res=new ArrayList<>();

    private void addWord(String word){
        TrieNode cur=root;
        for(char c:word.toCharArray()){
            if(cur.children[c-'a']==null){
                cur.children[c-'a']=new TrieNode();
            }
            cur=cur.children[c-'a'];
        }
        cur.endOfWord=true;
    }

    private void dfs(char[][] board, int row, int col, TrieNode cur, int[][] visited, StringBuilder sb){
        if(row<0 || row>=board.length || col<0 || col>=board[0].length || visited[row][col]==1) return;
        char c=board[row][col];
        if(cur.children[c-'a']==null) return;
        TrieNode next=cur.children[c-'a'];
        visited[row][col]=1;
        sb.append(c);

        if(next.endOfWord){
            res.add(sb.toString());
            next.endOfWord=false;
        }
 
        dfs(board,row,col-1,cur.children[c-'a'],visited,sb); // left
        dfs(board,row-1,col,cur.children[c-'a'],visited,sb); // top
        dfs(board,row,col+1,cur.children[c-'a'],visited,sb); // right
        dfs(board,row+1,col,cur.children[c-'a'],visited,sb); // bottom

        visited[row][col]=0;
        sb.deleteCharAt(sb.length()-1);
    }

    public List<String> findWords(char[][] board, String[] words) {
        for(String word:words) addWord(word);
        int m=board.length; // rows
        int n=board[0].length; // cols

        int[][] visited=new int[m][n];
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dfs(board,i,j,root,visited,sb);
            }
        }
        return res;
    }
}
