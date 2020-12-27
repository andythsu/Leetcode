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
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        ListNode n1 = l1;
        ListNode n2 = l2;
        ListNode head = new ListNode(-1);
        ListNode sumList = head;
        while(n1 != null){
            s1.push(n1.val);
            n1 = n1.next;
        }
        while(n2 != null){
            s2.push(n2.val);
            n2 = n2.next;
        }
        int carry = 0;
        while(!s1.empty() || !s2.empty()){
            int x = s1.empty() ? 0 : s1.pop();
            int y = s2.empty() ? 0 : s2.pop();
            int sum = x + y + carry;
            carry = sum / 10;
            sumList.next = new ListNode(sum % 10);
            sumList = sumList.next;
        }
        if(carry > 0){
            sumList.next = new ListNode(1);
        }
        return reverseList(head.next);
    }
    public ListNode reverseList(ListNode head){
        ListNode prev = null;
        ListNode cur = head;
        while(head != null){
            cur = head;
            head = head.next;
            cur.next = prev;
            prev = cur;
        }
        return prev;
    }
}
