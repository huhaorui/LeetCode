package leetcode;

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
class Solution {
    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        System.out.println(new Solution().rotateRight(head, 1));
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        int length = 1;
        ListNode ptr = head;
        while (ptr.next != null) {
            length++;
            ptr = ptr.next;
        }
        k %= length;
        if (k == 0) {
            return head;
        }
        k = length - k;
        ListNode newHead = head;
        ListNode prev = new ListNode(-1, newHead);
        for (int i = 0; i < k; i++) {
            newHead = newHead.next;
            prev = prev.next;
        }
        ListNode tmp = prev;
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        tmp.next = head;
        prev.next = null;
        return newHead;
    }
}