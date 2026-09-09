public class TrieNode{
    TrieNode[] children=new TrieNode[26];
    boolean endOfWord=false;
}

class WordDictionary {

    TrieNode root;

    public WordDictionary() {
        root=new TrieNode();
    }

    public void addWord(String word) {
        TrieNode cur=root;
        for(char c:word.toCharArray()){
            if(cur.children[c-'a']==null){
                cur.children[c-'a']=new TrieNode();
            }
            cur=cur.children[c-'a'];
        }
        cur.endOfWord=true;
    }

    private boolean dfs(TrieNode cur, int i, String word){
        // word traversed completely
        if(i==word.length()) return cur.endOfWord;
        char c=word.charAt(i);

        // normal character
        if(c!='.'){
            if(cur.children[c-'a']!=null){
                if(dfs(cur.children[c-'a'],i+1,word)) return true;
            }
            return false;
        }
       
        // try every possible character
        for(int j=0;j<26;j++){
            if(cur.children[j]!=null){
                if(dfs(cur.children[j],i+1,word)) return true;
            }
        }
        
        return false;
    }

    public boolean search(String word) {
        TrieNode cur=root;
        return dfs(cur,0,word);
    }
}
