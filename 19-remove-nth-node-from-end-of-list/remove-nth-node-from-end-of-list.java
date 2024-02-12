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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = new ListNode(0);
        temp.next = head;
        ListNode s = temp;
        ListNode c = temp;

        for(int i = 0; i <= n; i++) {
            s = s.next;
        }

        while(s != null) {
            s = s.next;
            c = c.next;
        }

        c.next = c.next.next;

        return temp.next;
    }
}