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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>>res=new ArrayList<>();
        if(root==null) return res;
        Queue<TreeNode> bfs=new LinkedList<>();
        bfs.offer(root);
        while(!bfs.isEmpty()){
            int size=bfs.size();
            List<Integer>li=new ArrayList<>();
            while(size!=0){
                TreeNode node=bfs.poll();
                li.add(node.val);
                if(node.left!=null) bfs.offer(node.left);
                if(node.right!=null) bfs.offer(node.right);
                size--;
            }
            res.add(li);
        }
        return res;
    }
}
