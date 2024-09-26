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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode sentinel = new ListNode(-1);
        ListNode result = sentinel;
        boolean flag = false;

        while(head != null && head.next != null) {
            
            while(head != null && head.next != null && head.val == head.next.val){
                head = head.next;
                flag = true;
            }

            if(!flag) {
                sentinel.next = head;
                sentinel = sentinel.next;
            } else {
                sentinel.next = null;
            }

            flag = false;

            head = head.next;
        }

        if(!flag) {
            sentinel.next = head;
        }


        return result.next;

    }
}