/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    HashMap<TreeNode, HashSet<TreeNode>> map;

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Queue<TreeNode> queue = new LinkedList<>();
        HashSet<Integer> seen = new HashSet<>();
        List<Integer> result = new ArrayList<>();
        map = new HashMap<>();
        int level = 0;

        if (level == k) { //only happend when we have a single node and k == 0
            result.add(target.val);
            return result;
        }


        //mapping graph
        buildGraphDfs(root);

        //BFS over graph

        TreeNode node = null;

        queue.add(target);

        while (!queue.isEmpty()) {

            if(level == k) {
                while(!queue.isEmpty()) {
                    result.add(queue.remove().val);
                }
            } 

            int size = queue.size();

    
            for (int i = 0; i < size; i++) {
                node = queue.remove();
                seen.add(node.val);
                HashSet<TreeNode> children = map.get(node);


                for (TreeNode c : children) {
                    
                     if (!seen.contains(c.val)) {
                        queue.add(c);
                    }
                }
            }

            level++;
        }

        return result;
    }

    private void buildGraphDfs(TreeNode node) {
        if (node == null)
            return;

        if(!map.containsKey(node)) {
            map.put(node, new HashSet<>());
        }

        if (node.left != null) {
            map.get(node).add(node.left);
            
            if(!map.containsKey(node.left)) {
                map.put(node.left, new HashSet<>());
            }

            map.get(node.left).add(node);

            buildGraphDfs(node.left);
        }

        if (node.right != null) {
            map.get(node).add(node.right);

            if(!map.containsKey(node.right)) {
                map.put(node.right, new HashSet<>());
            }

            map.get(node.right).add(node);

            buildGraphDfs(node.right);
        }

    }
}