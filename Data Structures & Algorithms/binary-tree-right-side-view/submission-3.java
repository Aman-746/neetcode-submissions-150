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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer>res=new ArrayList<>();
        if(root==null) return res;
        Queue<TreeNode>bfs=new LinkedList<>();
        bfs.offer(root);
        while(!bfs.isEmpty()){
            int n=bfs.size();
            for(int i=0;i<n;i++){
                TreeNode node=bfs.poll();
                if(i==0) res.add(node.val);
                if(node.right!=null) bfs.offer(node.right);
                if(node.left!=null) bfs.offer(node.left);
            }
        }
        return res;
    }
}
