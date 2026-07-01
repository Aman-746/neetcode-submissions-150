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
    private int maxDepth(TreeNode node){
        if(node==null) return 0;
        return 1+Math.max(maxDepth(node.left),maxDepth(node.right));
    }

    public int diameterOfBinaryTree(TreeNode root) {
        // for each node, i'll find maxDepth
        if(root==null) return 0;
        Queue<TreeNode>queue=new LinkedList<>();
        queue.offer(root);
        int ans=0;
        while(!queue.isEmpty()){
            TreeNode node=queue.poll();
            ans=Math.max(ans,maxDepth(node.left)+maxDepth(node.right));
            if(node.left!=null) queue.offer(node.left);
            if(node.right!=null) queue.offer(node.right);
        }
        return ans;
    }
}
