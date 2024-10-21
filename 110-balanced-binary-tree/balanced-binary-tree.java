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
    
    public boolean isBalanced(TreeNode root) {

        return dfs(root) != Integer.MAX_VALUE;    
    }


    private int dfs(TreeNode node) {
        if(node == null) {
            return 0;
        }

        int l =  dfs(node.left);
        int r =  dfs(node.right);

        if( l == Integer.MAX_VALUE || r == Integer.MAX_VALUE ||  Math.abs(l - r) > 1) {
            return Integer.MAX_VALUE;
        }

        return Math.max(l, r) + 1;
    }
}