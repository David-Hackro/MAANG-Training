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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(0);
        ListNode numbers = ans;
        int result = 0;

        while(l1 != null || l2 != null) {
            ListNode temp = new ListNode(result);

            if(l1 != null) {
                temp.val = temp.val + l1.val;
                l1 = l1.next;
            }

            if(l2 != null) {
                temp.val = temp.val + l2.val;
                l2 = l2.next;
            }

            if(temp.val > 9) {
                result = temp.val / 10;
                temp.val %= 10; 
            } else {
                result = 0;
            }

            numbers.next = temp;
            numbers = numbers.next;
        }

        if(result > 0){
            numbers.next = new ListNode(result);
            numbers = numbers.next; 
        }

     return ans.next;          
    }
}