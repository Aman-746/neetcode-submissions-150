/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int maxDepth(TreeNode root) {
        // BFS iterative traversal
        // As long as our level will increase our answer will also increase
        if(root==null) return 0;
        Queue<TreeNode> bfs=new LinkedList<>();
        bfs.offer(root);
        int level=0;
        while(!bfs.isEmpty()){
            int size=bfs.size();
            for(int i=0;i<size;i++){
                TreeNode node=bfs.poll();
                if(node.left!=null) bfs.offer(node.left);
                if(node.right!=null) bfs.offer(node.right);
            }
            level++;
        }
        return level;
    }
}
