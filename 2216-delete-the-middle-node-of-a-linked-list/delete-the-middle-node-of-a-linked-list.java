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
    public ListNode deleteMiddle(ListNode head) {
        if(head.next == null) {
            return head.next;
        }
        ListNode result = new ListNode(0, head);
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            result = result.next;
        }
            
        result.next = result.next.next; 

        return head;
    }
}

