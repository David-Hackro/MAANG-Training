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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        String a = getString(root1);
        String b = getString(root2); 
        return a.equals(b);
    }

    public String getString(TreeNode node) {
        String x = "";

        if(node == null) return "";

        if(node.left == null && node.right == null) return node.val + ",";


        x += getString(node.left);
        x += getString(node.right);

        return x;
    }
}




