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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList();
        String path = "";
        paths(root, result, path);

        return result;
    }

    public void paths(TreeNode node, List<String> list, String path) {
        String t = path + node.val;
        
        if (node.left == null && node.right == null) {
            list.add(t);
        }

        if (node.left != null) {
            paths(node.left, list, t + "->");
        }

        if (node.right != null) {
            paths(node.right, list, t + "->");
        }
    }
}
