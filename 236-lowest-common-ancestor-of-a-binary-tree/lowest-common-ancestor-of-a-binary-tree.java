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
    HashMap<Integer, TreeNode> map = new HashMap<>();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p.val, q.val);
        List<Integer> list = new ArrayList<>();
        list.add(p.val);
        TreeNode temp = p;

        while(map.containsKey(temp.val)) {
            list.add(map.get(temp.val).val);
            temp = map.getOrDefault(temp.val, null);
        }     

        temp = q;
        while(temp != null) {
            if(list.contains(temp.val)) {
                return temp;
            }

            temp = map.getOrDefault(temp.val, null);
        }

        return null;

    }

    public void dfs(TreeNode node, int p, int q) {
        if(node == null || (map.containsKey(p) && map.containsKey(q))) {
            return;
        }

        if(node.left != null) {
            map.put(node.left.val, node);
            dfs(node.left,p,q);
        }

        if(node.right != null) {
            map.put(node.right.val, node);
            dfs(node.right,p,q);
        }

    }
}