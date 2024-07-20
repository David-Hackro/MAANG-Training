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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        /*
        nums =[3,2,1,6,0,5]
        Output[6,3,6,null,3,null,6,null,3]
        */
        int index = 0;
        int l = 0;
        int r = nums.length -1;

        while(l <= r) {
            if(nums[l] > nums[index]) {
                index = l;
            }

            if(nums[r] > nums[index]) {
                index = r;
            }

            l++;
            r--;
        }

        TreeNode node = new TreeNode(nums[index]);
        
        if(index > 0) {
            node.left = constructMaximumBinaryTree(Arrays.copyOfRange(nums, 0, index));
        }

        if(index < nums.length - 1) {
            node.right = constructMaximumBinaryTree(Arrays.copyOfRange(nums, index + 1, nums.length));
        }

        return node;
    }
}