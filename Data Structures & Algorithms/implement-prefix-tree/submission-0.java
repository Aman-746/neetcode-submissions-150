public class TrieNode{
    TrieNode[] node=new TrieNode[26];
    boolean ended=false;
}

class PrefixTree {

    TrieNode root;

    public PrefixTree() {
         root=new TrieNode();
    }

    public void insert(String word) {
        TrieNode cur=root;
        for(char c:word.toCharArray()){
            if(cur.node[c-'a']==null){
                cur.node[c-'a']=new TrieNode();
            }
            cur=cur.node[c-'a'];
        }
        cur.ended=true;
    }

    public boolean search(String word) {
        TrieNode cur=root;
        for(char c:word.toCharArray()){
            if(cur.node[c-'a']==null) return false;
            cur=cur.node[c-'a'];
        }
        if(cur.ended==true) return true;
        return false;
    }

    public boolean startsWith(String prefix) {
        TrieNode cur=root;
        for(char c:prefix.toCharArray()){
            if(cur.node[c-'a']==null) return false;
            cur=cur.node[c-'a'];
        }
        return true;
    }
}
