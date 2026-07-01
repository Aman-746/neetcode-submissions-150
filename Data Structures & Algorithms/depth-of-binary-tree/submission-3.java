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
        // now we will try to solve with iterative preorder dfs traversal
        if(root==null) return 0;
        Stack<Pair<TreeNode,Integer>> stack=new Stack<>();
        stack.push(new Pair<>(root,1));
        int res=0;
        while(!stack.isEmpty()){
            Pair<TreeNode,Integer> current=stack.pop();
            TreeNode node=current.getKey();
            int depth=current.getValue();
            res=Math.max(res,depth);
            if(node.left!=null) stack.push(new Pair<>(node.left,depth+1));
            if(node.right!=null) stack.push(new Pair<>(node.right,depth+1));
        }
        return res;
    }
}
