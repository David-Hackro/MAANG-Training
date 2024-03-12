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
        if(root == null) {
            return false;
        }
        return hasTargetValue(root, targetSum,  0);
    }

    public boolean hasTargetValue(TreeNode node, int targetSum, int acum) {
        
        if(node == null) {
            return false;
        }
        if(node.left == null && node.right == null) {
            return acum + node.val == targetSum;
        }

        boolean l = hasTargetValue(node.left, targetSum, acum + node.val);
        boolean r = hasTargetValue(node.right, targetSum, acum + node.val);

        return l || r;
    }

}