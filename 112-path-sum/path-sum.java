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
    //[] 0
    public boolean hasPathSum(TreeNode root, int targetSum) {
        int acum = 0;

        return isTargetValue(root, targetSum, acum);
    }

    public boolean isTargetValue(TreeNode node, int targetSum, int acum) {

        if(node == null) {
            return false;
        }

        acum += node.val;
        if(node.left == null && node.right == null) {
            return acum == targetSum;
        }

        boolean l = isTargetValue(node.left, targetSum, acum);
        boolean r = isTargetValue(node.right, targetSum, acum);

        return l || r;
    }
}
