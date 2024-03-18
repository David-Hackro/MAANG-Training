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
    public int minDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }

        return getMinPath(root, 0, Integer.MAX_VALUE);
    }

    private int getMinPath(TreeNode node, int counter, int min) {
        
        if(counter > min) {
            return min;
        }
        
        if(node == null) {
            return min;
        }

        counter++;

        if(node.left == null && node.right == null) {
            return Math.min(min, counter);
        }

        int left = getMinPath(node.left, counter, min);
        int right = getMinPath(node.right, counter, min);
        
        return Math.min(left, right);
    }
}







