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
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        SortedSet<String> set1 = new TreeSet<>();
        SortedSet<String> set2 = new TreeSet<>();
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
     
        if(root1 == null && root2 == null) {
            return true;
        }

        if (((root1 == null && root2 != null) || (root1 != null && root2 == null)) || root1.val != root2.val) {
            return false;
        }

        queue1.add(root1);
        queue2.add(root2);

        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            int size1 = queue1.size();

            for (int i = 0; i < size1; i++) {
                TreeNode node1 = queue1.remove();
                TreeNode left1 = node1.left;
                TreeNode right1 = node1.right;

                set1.add(getHash(node1, left1, right1));

                if (node1.left != null) {
                    queue1.add(node1.left);
                }

                if (node1.right != null) {
                    queue1.add(node1.right);
                }

            }

            /// validate that this pairs exist in the other tree
            int size2 = queue2.size();
            if (size1 != size2) {
                return false;
            }

            for (int i = 0; i < size2; i++) {
                TreeNode node2 = queue2.remove();
                TreeNode left2 = node2.left;
                TreeNode right2 = node2.right;

                set2.add(getHash(node2, left2, right2));

                if (node2.left != null) {
                    queue2.add(node2.left);
                }

                if (node2.right != null) {
                    queue2.add(node2.right);
                }
            }

            if (!set1.equals(set2)) {
                return false;
            }

            set1 = new TreeSet<>();
            set2 = new TreeSet<>();
        }

        return set1.equals(set2);
    }

    private String getHash(TreeNode parent, TreeNode left, TreeNode right) {
        int l = left == null ? -1 : left.val;
        int r = right == null ? -1 : right.val;

        int[] array = new int[] { l, r };
        Arrays.sort(array);
        StringBuilder sb = new StringBuilder();
        sb.append(parent.val);
        sb.append(array[0]);
        sb.append(",");
        sb.append(array[1]);
        return sb.toString();
    }

}