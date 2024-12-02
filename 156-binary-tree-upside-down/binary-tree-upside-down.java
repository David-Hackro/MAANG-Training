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
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if(root == null || root.left == null && root.right == null) {
            return root;
        }

        TreeNode result = root;
        
        while(result.left != null) {
            result = result.left;
        }
    
        updateTree(null, root);

        return result;
    }


    private void updateTree(TreeNode parent, TreeNode current) {

        if(current == null) {
            return;
        }

        updateTree(current, current.left);
        
        if(parent == null) {
            return;
        }

        current.right = parent;
        current.left = parent.right;
        parent.left = null;
        parent.right = null;
    }
}












