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
    TreeNode prev;
    int min = Integer.MAX_VALUE;

    private void getMinAbsDiff(TreeNode node) {
        if(node == null) {
            return;
        }

        getMinAbsDiff(node.left);

        if(prev != null) {
            min = Math.min(min, node.val - prev.val);
        }
        prev = node;

        getMinAbsDiff(node.right);
    }

    public int getMinimumDifference(TreeNode root) {
        getMinAbsDiff(root);

        return min;
    }
}
