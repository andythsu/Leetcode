/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode sum = head;
        ListNode d1 = l1;
        ListNode d2 = l2;
        int carry = 0;
        while(d1 != null || d2 != null){
            int x = d1 == null ? 0 : d1.val;
            int y = d2 == null ? 0 : d2.val;
            int digit = x + y + carry;
            carry = digit / 10;
            sum.next = new ListNode(digit % 10);
            sum = sum.next;
            if(d1 != null) d1 = d1.next;
            if(d2 != null) d2 = d2.next;
        }
        if(carry > 0){
            sum.next = new ListNode(carry);
        }
        return head.next;
    }
}
