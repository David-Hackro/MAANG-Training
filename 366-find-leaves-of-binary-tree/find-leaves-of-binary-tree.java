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

    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        list = new ArrayList<>();


        while(root != null) {
            list = new ArrayList<>();

            root = dfs(root);
            result.add(list);
        }

        return result;
    }


    private TreeNode dfs(TreeNode root) {
        if(root == null) {
            return null;
        }

        if(root.left == null && root.right == null) {
            list.add(root.val);
            return null;
        }


        root.left = dfs(root.left);
        root.right = dfs(root.right);
        
        return root;
    }
}