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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null) {
            return result;
        }
        List<Integer> temp = new ArrayList<>();
        temp.add(root.val);

        queue.add(root);
        result.add(temp);

        while(!queue.isEmpty()) {
            int size = queue.size();
            temp = new ArrayList<>();

            for(int i = 0; i < size; i++) {
                TreeNode node = queue.remove();

                if(node.left != null) {
                    queue.add(node.left);
                    temp.add(node.left.val);
                }

                if(node.right != null) {
                    queue.add(node.right);
                    temp.add(node.right.val);
                }
            }

            if(!temp.isEmpty()) {
                result.add(temp);
            }
        }

        Collections.reverse(result);

        return result;
    }
}