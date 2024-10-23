/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    int[] xArray;
    int[] yArray;

    public boolean isCousins(TreeNode root, int x, int y) {
        // [depth][parent]
        xArray = new int[2];
        yArray = new int[2];

        dfs(root, x, y, 0, -1);

        return xArray[0] == yArray[0] && xArray[1] != yArray[1];
    }

    private void dfs(TreeNode node, int x, int y, int depth, int parent) {

        if (node == null) {
            return;
        }

        if (node.val == x || node.val == y) {

            if (node.val == x) {
                xArray[0] = depth;
                xArray[1] = parent;
            } else {
                yArray[0] = depth;
                yArray[1] = parent;
            }
        }

        dfs(node.left, x, y, depth + 1, node.val);
        dfs(node.right, x, y, depth + 1, node.val);
    }

}