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
    public ListNode mergeNodes(ListNode head) {
        ListNode l = head;
        ListNode r = head.next;
        int prefix = 0;

        while(r != null) {
            //[0,3,1,0,4,5,2,0]

            if(r.val != 0) {
                prefix += r.val;
            } else {
                l.val = prefix;
                if(r.next != null)
                    l = l.next;
                else {
                    l.next = null;
                }
                prefix = 0;
            }

            r = r.next;
        }

        return head;
    }
}





