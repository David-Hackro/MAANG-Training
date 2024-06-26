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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<Integer> temp = new ArrayList<>();
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        Queue<Integer> levels = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if(root == null) {
            return new ArrayList<>();
        }

        queue.add(root);
        levels.add(0);
        temp.add(root.val);
        map.put(0, temp);
    
        while(!queue.isEmpty()) {
            int size = queue.size();

            for(int i = 0; i < size; i++) {
                TreeNode n = queue.remove();
                int l = levels.remove();

                if(n.left != null) {
                    queue.add(n.left);
                    levels.add(l - 1);
                    List<Integer> a = map.getOrDefault(l - 1, new ArrayList<>());
                    a.add(n.left.val); 
                    map.put(l - 1, a);
                }

                if(n.right != null) {
                    queue.add(n.right);
                    levels.add(l + 1);
                    List<Integer> b = map.getOrDefault(l + 1, new ArrayList<>());
                    b.add(n.right.val); 
                    map.put(l + 1, b);
                }
            }

        }

        Map<Integer, List<Integer>> treeMap = new TreeMap<>(map);

        return new ArrayList<List<Integer>>(treeMap.values()); 
    }
}
