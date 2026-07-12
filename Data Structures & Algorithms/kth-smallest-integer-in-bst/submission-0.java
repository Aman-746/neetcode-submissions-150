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
    boolean found=false;

    private void dfs(TreeNode root, int[] arr){
        if(root==null || found==true) return;
        dfs(root.left,arr);
        arr[0]--;
        if(arr[0]==0) {
            res=root.val;
            found=true;
            return;
        }
        dfs(root.right,arr);
    }
    public int kthSmallest(TreeNode root, int k) {
        // inorder traversal
        int[] arr=new int[1];
        arr[0]=k;
        dfs(root,arr);
        return res;
    }
}
