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
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<Integer> list = new ArrayList<>();
        int counter = 0;
        dfs(list, counter, root, targetSum);
        return result;    
    }

    private void dfs(List<Integer> list, int counter, TreeNode node, int targetSum) {
        if(node == null) {
            return;
        }        

        List<Integer> listNew = new ArrayList<>();
        listNew.addAll(list);

        if(node.left == null && node.right== null) {
            if(counter + node.val == targetSum) {
                result.add(listNew);
            } else {
                return;
            }
        }
        listNew.add(node.val);

        dfs(listNew, counter + node.val, node.left, targetSum);
        dfs(listNew, counter + node.val, node.right, targetSum);
    }
}