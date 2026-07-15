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
    int res=Integer.MIN_VALUE;

    private int getMax(TreeNode node){
        if(node==null) return 0;
        int left=getMax(node.left);
        int right=getMax(node.right);
        int path=node.val+Math.max(left,right);
        return Math.max(0,path);
    }

    private void dfs(TreeNode root){
        if(root==null) return;
        int left_max=getMax(root.left);
        int right_max=getMax(root.right);
        res=Math.max(res,root.val+left_max+right_max);
        dfs(root.left);
        dfs(root.right);
    }

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return res;
    }


}
