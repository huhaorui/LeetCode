/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution_61 {
    public ListNode rotateRight(ListNode head, int k) {
        ListNode newHead = head;
        for (int i = 0; i <= k; i++) {
            newHead = newHead.next;
        }
        return newHead;
    }
}