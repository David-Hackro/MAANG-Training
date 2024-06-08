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
    HashMap<Long, Integer> map = new HashMap<>();
    Long prefix = 0L;

    public int pathSum(TreeNode root, int targetSum) {
        if(root == null) {
            return 0;
        }    

        int counter = 0;
        prefix += root.val;
        long t = prefix - ((long) targetSum);

        counter += map.getOrDefault(t, 0);
        if(prefix == (long)targetSum) {
            counter++;
        }
        
        map.put(prefix, map.getOrDefault(prefix, 0) + 1);
    

        counter += pathSum(root.left, targetSum);
        counter += pathSum(root.right, targetSum);

        map.put(prefix, map.getOrDefault(prefix, 1) - 1);
        prefix -= root.val;

        return counter;
    }
}