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
    private boolean isSameTree(TreeNode root, TreeNode subRoot){
        if(root==null && subRoot==null) return true;
        if(root==null && subRoot!=null) return false;
        if(root!=null && subRoot==null) return false;
        if(root.val!=subRoot.val) return false;
        return isSameTree(root.left,subRoot.left) && isSameTree(root.right,subRoot.right);
    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode node=queue.poll();
            if(node.left!=null) queue.offer(node.left);
            if(node.right!=null) queue.offer(node.right);
            if(isSameTree(node,subRoot)) return true;
        }
        return false;
    }
}
