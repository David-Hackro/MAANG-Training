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
    public int maxAncestorDiff(TreeNode root) {
        return getMaxDiff(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    private int getMaxDiff(TreeNode node, int min, int max) {
        if(node  == null) {
            return max - min;
        }   
        min = Math.min(min, node.val);
        max = Math.max(max, node.val);

        int l =  getMaxDiff(node.left, min, max);
        int r =  getMaxDiff(node.right, min, max);

        return Math.max(l, r);
    }
}






