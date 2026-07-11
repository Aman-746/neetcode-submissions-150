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
    int res=0;

    private void count(TreeNode node, int maxTillNow){
        if(node==null) return;
        maxTillNow=Math.max(maxTillNow,node.val);
        if(node.left!=null) count(node.left,maxTillNow);
        if(node.right!=null) count(node.right,maxTillNow);
        if(node.val==maxTillNow) res++;
    }

    public int goodNodes(TreeNode root) {
        if(root==null) return 0;
        count(root,root.val);
        return res;
    }
}
