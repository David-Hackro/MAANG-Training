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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        
        return hasPathSum(root, targetSum, 0);
    }

    public boolean hasPathSum(TreeNode node, int targetSum, int prefix) {
        if(node == null) {
            return false;
        }

        prefix += node.val;

        if(node.left == null && node.right == null) {
            return prefix == targetSum;
        }

        boolean l = hasPathSum(node.left, targetSum, prefix);
        boolean r = hasPathSum(node.right, targetSum, prefix);

        return l || r;
    }


}









