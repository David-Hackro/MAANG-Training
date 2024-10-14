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
    List<Integer> list;

    public int kthLargestPerfectSubtree(TreeNode root, int k) {
        list = new ArrayList<>();
        
        dfs(root);

        Collections.sort(list);

        if(list.size() <  k) {
            return -1;
        }

        return list.get(list.size() - k);
    }

    private int dfs(TreeNode root) {

        if(root == null) return 0;

        if(root.left == null && root.right == null) { //where is a leaf
            list.add(1);
            return 1;
        }

        int l = dfs(root.left);
        int r = dfs(root.right);

        if(l == r && ((l + r + 1) % 2 != 0) && l >=0 && r  >=0 ) { // a perfect subtree should be odd 
            list.add(l + r + 1);
            return l + r + 1;
        }

        return -1;
    }
}