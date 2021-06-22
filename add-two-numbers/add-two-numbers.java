/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        int sum = 0;
        int tempSum = 0;
        ListNode root = new ListNode(0);
        ListNode dum = root;
        ListNode cur = null;
        while(l1 != null || l2 != null){
            int l1Val = l1 != null ? l1.val : 0;
            int l2Val = l2 != null ? l2.val : 0;
            tempSum = l1Val + l2Val + carry;
            carry = tempSum / 10;
            cur = new ListNode(tempSum % 10);
            root.next = cur;
            root = root.next;
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }
        
        if(carry > 0) {
            root.next = new ListNode(carry);
        }
        
        return dum.next;
        
    }
}