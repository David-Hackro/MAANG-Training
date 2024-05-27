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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) {
            return new TreeNode(val);
        }       

        TreeNode l = root.left;
        TreeNode r = root.right;


        if(root.val > val) {
          l = insertIntoBST(root.left, val);
        } 
        
        if(root.val < val) {
            r = insertIntoBST(root.right, val);
        }

        root.left = l;
        root.right = r;

        return root;
    }

    
}