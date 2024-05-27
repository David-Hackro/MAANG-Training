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
    public int closestValue(TreeNode root, double target) {
        
        return minDiff(root, target, Integer.MAX_VALUE);   
    }

    public int minDiff(TreeNode node, double target, int min) {

            double diff1 = Math.abs(((double)node.val) - target);
            double diff2 = Math.abs(((double) min) - target);

        if(diff1 == diff2) {
            min = Math.min(node.val, min);
        } else if (diff1 < diff2) {
            min = node.val;
        }

        if(node.left != null) {
            min = minDiff(node.left, target, min);
        }

        if(node.right != null) {
            min = minDiff(node.right, target, min);
        }
        
        return min;
    }
}
