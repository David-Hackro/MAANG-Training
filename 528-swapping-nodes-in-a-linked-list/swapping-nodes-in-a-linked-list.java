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

        // Avanzar s1 hasta el k-ésimo nodo
        while (s1 != null && counter < k - 1) {
            s1 = s1.next;
            counter++;
        }

        // Guardar la posición de s1 para el primer nodo
        ListNode temp = s1;

        // Mover s1 al final de la lista
        while (s1.next != null) {
            s1 = s1.next;
            s3 = s3.next;
        }

        // Swap values between s2 y s3
        int tempVal = temp.val;
        temp.val = s3.val;
        s3.val = tempVal;

        return head;
    }
}