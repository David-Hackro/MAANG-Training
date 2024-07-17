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
    List<Integer> list = new ArrayList<>();
    List<TreeNode> result = new ArrayList<>();
    
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {

        for(int n : to_delete) {
            list.add(n);
        }        
        dfs(root, true);

        return result;    
    }

    public void dfs(TreeNode node, boolean flag) {
        if(node == null) {
            return;
        }

        if(flag && !list.contains(node.val)) {
            result.add(node);
        }

        boolean temp = list.contains(node.val);

        if(node.left != null && list.contains(node.left.val)) {
            TreeNode a = node.left;
            node.left = null;
            dfs(a, temp); 
        } else {
            dfs(node.left, temp);
        }

        if(node.right != null && list.contains(node.right.val)) {
            TreeNode b = node.right;
            node.right = null;
            dfs(b, temp); 
        } else {
            dfs(node.right, temp);
        }
    }


}