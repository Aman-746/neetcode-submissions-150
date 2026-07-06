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
    private String serialize(TreeNode root){
        if(root==null) return "$#";
        return "$"+root.val+serialize(root.left)+serialize(root.right);
    }

    // z-algorithm to find a pattern as a prefix in a string
    private int[] z_function(char input[]){
        int n=input.length;
        int z[]=new int[n];
        int left=0; 
        int right=0;
        for(int i=1;i<n;i++){
            if(i>right){
                left=i;
                right=i;
                while(right<n && input[right]==input[right-left]) right++;
                z[i]=right-left;
                right--;
            } else{
                if(z[i-left]+i>=right+1){
                    left=i;
                    while(right<n && input[right]==input[right-left]) right++;
                    z[i]=right-left;
                    right--;
                } else{
                    z[i]=z[i-left];
                }
            }
        }
        return z;
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        String serialized_root=serialize(root);
        String serialized_subRoot=serialize(subRoot);
        String combined = serialized_subRoot+"|"+serialized_root;

        int[] z_values=z_function(combined.toCharArray());
        int sub_len=serialized_subRoot.length();
        for(int i=sub_len+1; i<combined.length();i++){
            if(z_values[i]==sub_len) return true;
        }
        return false;
    }
}
