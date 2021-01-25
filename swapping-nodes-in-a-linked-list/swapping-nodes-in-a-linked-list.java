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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode iterator = head;
        for(int i=1; i<k; i++){
            iterator = iterator.next;
            slow = slow.next;
        }
        while(iterator.next != null){
            iterator = iterator.next;
            fast = fast.next;
        }
        
        int temp = slow.val;
        slow.val = fast.val;
        fast.val = temp;
        
        return head;
        
    }
}
