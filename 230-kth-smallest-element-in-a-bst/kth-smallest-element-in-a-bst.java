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
    int n = 0;
    int k = 0;

    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        smallest(root);

        return n;
    }

    public void smallest(TreeNode node) {
        if(node == null) return;

        smallest(node.left);
        k--;
        if(k == 0) {
            n = node.val;
            return;
        }
        smallest(node.right);
    }
}
