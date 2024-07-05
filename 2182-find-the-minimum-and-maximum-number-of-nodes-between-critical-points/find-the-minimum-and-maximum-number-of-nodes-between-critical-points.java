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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int f = 0;
        int s = 0;
        long min = Long.MAX_VALUE;
        long max = -Long.MAX_VALUE;
        int i = 1;
        int prev = head.val;
        head = head.next;

        while(head != null && head.next != null) {
            
            if((prev < head.val && head.val > head.next.val) || (prev > head.val && head.val < head.next.val)) {
                
                if(f == 0) {
                    f = i;
                    s = i;
                } else {
                    min = Math.min(min, i -s);
                    max = Math.max(max, i - f);
                    s = i;
                }

            }

            prev = head.val;
            head = head.next;
            i++;
        }
    

        if(s == 0 || (int)min == -1 || (int)max == -1) {
            return new int[] {-1,-1};
        }

        return new int[] {(int)min, (int) max};
    }
}





