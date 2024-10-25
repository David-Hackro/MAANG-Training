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
    HashSet<String> set;

    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        set = new HashSet<>();

        if (root1 == null && root2 == null) {
            return true;
        }

        if ((root1 != null && root2 == null) || (root1 == null && root2 != null) || (root1.val != root2.val)) {
            return false;
        }

        dfsTree1(root1); // fill the set with tree1

        return dfsTree2(root2) && set.isEmpty(); // validate that the children exist
    }

    private void dfsTree1(TreeNode node) {
        if (node == null) {
            return;
        }

        set.add(getHash(node, node.left));
        dfsTree1(node.left);

        set.add(getHash(node, node.right));
        dfsTree1(node.right);

    }

    private boolean dfsTree2(TreeNode node) {
        if (node == null) {
            return true;
        }

        if (!set.contains(getHash(node, node.left)) || !set.contains(getHash(node, node.right))) {
            return false;
        }

        set.remove(getHash(node, node.left));
        set.remove(getHash(node, node.right));

        return dfsTree2(node.left) && dfsTree2(node.right);
    }

    private String getHash(TreeNode parent, TreeNode node) {
        int p = parent == null ? -1 : parent.val;
        int n = node == null ? -1 : node.val;

        StringBuilder sb = new StringBuilder();
        sb.append(p);
        sb.append(",");
        sb.append(n);
        return sb.toString();
    }
}