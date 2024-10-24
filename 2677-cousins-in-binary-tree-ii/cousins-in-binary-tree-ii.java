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
    public TreeNode replaceValueInTree(TreeNode root) {
        List<TreeNode[]> queue = new ArrayList<>();

        queue.add(new TreeNode[] { null, root });

        while (!queue.isEmpty()) {
            int size = queue.size();
            int s = queue.size();
            int[] results = new int[size];

            for (int i = 0; i < size; i++) {
                TreeNode[] array = queue.remove(0);
                s--;
                TreeNode parent = array[0]; // null
                TreeNode current = array[1];// 5

                for (int x = 0; x < s; x++) {
                    TreeNode[] arrayTemp = queue.get(x);
                    TreeNode parentTemp = arrayTemp[0]; //
                    TreeNode currentTemp = arrayTemp[1];//

                    if (parentTemp != parent) {// are cousin
                        results[i] += currentTemp.val;
                        results[i + x + 1] += current.val;
                    }
                }

                if (current.left != null) {
                    queue.add(new TreeNode[] { current, current.left });
                }

                if (current.right != null) {
                    queue.add(new TreeNode[] { current, current.right });
                }

                // [0,0,0,7,7,null,11]
                current.val = results[i];
            }
        }

        return root;
    }
}