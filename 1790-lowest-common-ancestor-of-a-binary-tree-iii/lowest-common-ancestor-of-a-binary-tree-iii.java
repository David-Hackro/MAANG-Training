/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        List<Node> list = new ArrayList<>();

        while(p != null) {
            list.add(p);
            p = p.parent;
        }

        while(q != null) {
            if(list.contains(q)) {
                return q;
            }
            q = q.parent;
        }       

        return p;
    }
}