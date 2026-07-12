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
    private boolean dfs(TreeNode root, int mini, int maxi){
        if(root==null) return true;
        if(root.val<=mini || root.val>=maxi) return false;
        return dfs(root.left,mini,root.val) && dfs(root.right,root.val,maxi);
    }

    public boolean isValidBST(TreeNode root) {
        if(root==null) return true;
        int mini=Integer.MIN_VALUE;
        int maxi=Integer.MAX_VALUE;
        return dfs(root,mini,maxi);
    }
}
