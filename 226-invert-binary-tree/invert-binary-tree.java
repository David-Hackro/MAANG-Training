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
    public TreeNode invertTree(TreeNode root) {
        return swipe(root);       
    }

    private TreeNode swipe(TreeNode node) {

          if(node == null || node.left == null && node.right == null) {
            return node;
          }

          TreeNode l = swipe(node.left);
          TreeNode r = swipe(node.right);

          node.left = r;
          node.right = l;

          return node;
    }
}