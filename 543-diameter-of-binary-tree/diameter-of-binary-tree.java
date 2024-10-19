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
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);

        return max;
    }

    private int dfs(TreeNode node) {

        if(node == null) {
            return 0;
        }

        int l = dfs(node.left);//1
        int r = dfs(node.right);//0

        int x = l + r;

        max = Math.max(max, x);

        return Math.max(l, r) + 1;
    }
}