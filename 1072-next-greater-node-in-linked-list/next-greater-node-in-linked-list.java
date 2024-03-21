/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nextLargerNodes(ListNode head) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        int index = 0;

        while(head != null) {
            //[2,1,5]

            map.put(index, 0);

            while(!stack.isEmpty() && head.val > map.get(stack.peek())) {
                map.put(stack.pop(), head.val);
            }   

            map.put(index, head.val);
            stack.push(index++);

            head = head.next;
        }

        int[] result = new int[map.size()];

        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            result[entry.getKey()] = entry.getValue();
        }

        while(!stack.isEmpty()) {
            result[stack.pop()] = 0;
        }

        return result;
    }
}
