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
    public void reorderList(ListNode head) {
        ListNode mid = head, fast = head;
        while(fast != null && fast.next != null) {
            mid = mid.next;
            fast = fast.next.next;
        }
        ListNode cur = mid, prev = null, temp = null;
        while(cur != null) {
            temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        ListNode l1 = head, l2 = prev;
        while(l2.next != null) {
            temp = l1.next;
            l1.next = l2;
            l1 = temp;
            
            temp = l2.next;
            l2.next = l1;
            l2 = temp;
        }
    }
}