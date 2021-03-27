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

class Solution_82 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(4);
        System.out.println(new Solution_82().deleteDuplicates(head));
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        head = new ListNode(-10000, head);
        ListNode ptr = head.next;
        ListNode prev = head;
        while (ptr != null && ptr.next != null) {
            if (ptr.val == ptr.next.val) {
                ListNode tmp = ptr.next.next;
                while (tmp != null && ptr.val == tmp.val) {
                    tmp = tmp.next;
                }
                prev.next = tmp;
                ptr = prev.next;
            } else {
                ptr = ptr.next;
                prev = prev.next;
            }
        }
        return head.next;
    }
}