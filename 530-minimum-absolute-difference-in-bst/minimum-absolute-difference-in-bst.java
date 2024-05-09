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
    public int getMinimumDifference(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int result = Integer.MAX_VALUE;

        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                list.add(node.val);

                if(node.left != null) {
                    queue.add(node.left);
                }

                if(node.right != null) {
                    queue.add(node.right);
                }
            }
        }

        Collections.sort(list);

        for(int i = 1; i < list.size(); i++) {
            result = Math.min(result, list.get(i) - list.get(i -1));
        }


        return result;
    }
}

