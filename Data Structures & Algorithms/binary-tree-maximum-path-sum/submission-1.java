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
    private int dfs(TreeNode root, int[] res){
        if(root==null) return 0;
        int left=dfs(root.left,res);
        int right=dfs(root.right,res);
        res[0]=Math.max(res[0],root.val+left+right);
        return Math.max(0,root.val+Math.max(left,right));
    }
    public int maxPathSum(TreeNode root) {
        int[] res=new int[1];
        res[0]=Integer.MIN_VALUE;
        dfs(root,res);
        return res[0];
    }
}

// return the maximum path to the above node and simultaneously 
// keep computing the result
