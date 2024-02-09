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
    public ListNode swapNodes(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode s1 = head, s3 = head;
        int counter = 0;

        while (s1 != null && counter < k - 1) {
            s1 = s1.next;
            counter++;
        }

        ListNode temp = s1;

        while (s1.next != null) {
            s1 = s1.next;
            s3 = s3.next;
        }

        int tempVal = temp.val;
        temp.val = s3.val;
        s3.val = tempVal;

        return head;
    }
}