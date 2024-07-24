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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return dfs(0, preorder, inorder);   
    }

    public TreeNode dfs(int index, int[] preorder, int[] inorder) {
        
        if (inorder.length == 0 || index >= preorder.length) {
            return null;
        }
        
        int indexInOrder = 0;
        TreeNode node = new TreeNode(preorder[index]);

        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == preorder[index]) {
                indexInOrder = i;
                break;
            }
        }

        node.left = dfs(index + 1, preorder, Arrays.copyOfRange(inorder, 0, indexInOrder));
        node.right = dfs(index + indexInOrder + 1, preorder, Arrays.copyOfRange(inorder, indexInOrder + 1, inorder.length));

        return node;
    }
}
