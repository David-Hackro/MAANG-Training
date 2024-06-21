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

    public boolean checkEqualTree(TreeNode root) {
        int total = total(root);
        list.remove(list.size() -1);

        if(total % 2 != 0) {
            return false;
        }

        for(int n : list) {
            if(n == total / 2) {
                return true;
            }
        }

        return false;
    }


    public int total(TreeNode node) {
        if(node == null) {
            return 0;
        }

        int l = total(node.left);        
        int r = total(node.right);

        list.add(node.val + l + r);    

        return node.val + l + r;
    }

}

