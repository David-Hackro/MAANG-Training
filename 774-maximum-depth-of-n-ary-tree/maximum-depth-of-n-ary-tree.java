/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public int maxDepth(Node root) {
        if(root == null) {
            return 0;
        }

        int counter = 1;

        List<Node> list = new ArrayList<>(root.children);  

        while(!list.isEmpty()) {
            int size = list.size();

            for(int i = 0; i < size; i++) {
                if(list.get(size - i - 1).children != null) {
                    list.addAll(list.get(size - i - 1).children);
                }

                list.remove(size - i - 1);
            }

            counter++;
        }

        return counter;      
    }
}



