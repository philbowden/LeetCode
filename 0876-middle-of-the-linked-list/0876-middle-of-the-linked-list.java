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
    public ListNode middleNode(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode current = head;
        int count = 0;

        while(current != null) {
            count++;
            current = current.next;
        }
        int mid = count / 2;
        current = head;
        count = 0;

        while(count != mid-1) {
            current = current.next;
            count++;
        }
        return current.next;
    }
}