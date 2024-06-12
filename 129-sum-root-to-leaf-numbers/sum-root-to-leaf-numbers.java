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
    public int sumNumbers(TreeNode root) {
        
        return getResult(root, 0);
    }

    public int getResult(TreeNode node, int val) {
          if(node  == null) {
              return 0;
          }

          int t = val * 10 + node.val;

          if(node.left == null && node.right == null) {
              return t;
          }

          int l = getResult(node.left, t);
          int r = getResult(node.right, t);

          return l + r;
    }

}





