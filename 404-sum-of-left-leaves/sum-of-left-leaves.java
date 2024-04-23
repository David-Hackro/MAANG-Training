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
    public int sumOfLeftLeaves(TreeNode root) {
        if(root.left == null && root.right == null) {
            return 0;
        }
        return getSumLeafLeft(root, true);
    }

    private int getSumLeafLeft(TreeNode node, Boolean flag) {
        if(node == null) {
            return 0;
        }

        if(node.left == null && node.right == null && flag) {
            return node.val;
        }


        int l = getSumLeafLeft(node.left, true);
        int r = getSumLeafLeft(node.right, false);

        return l + r;
    }
}








