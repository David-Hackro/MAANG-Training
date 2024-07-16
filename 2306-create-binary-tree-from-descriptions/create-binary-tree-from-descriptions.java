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
    public TreeNode createBinaryTree(int[][] descriptions) {
        HashSet<Integer> set = new HashSet<>();
        HashMap<Integer, TreeNode> map = new HashMap<>();
        int head = 0;

        for(int[] a: descriptions) {
            int p = a[0];
            int c = a[1];
            boolean isLeft = a[2] > 0?true:false;

            TreeNode parent = map.getOrDefault(p, new TreeNode(p));
            TreeNode children = map.getOrDefault(c, new TreeNode(c));

            if(isLeft) {
                parent.left = children;
            } else{
                parent.right = children;
            }
            
            map.put(p, parent);
            map.put(c, children);

            set.add(c);
        }

        for (int key : map.keySet()) {
            if(!set.contains(key)) {
                return map.get(key);
            }
        }

        return null;
    }
}
