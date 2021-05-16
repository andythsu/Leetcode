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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode iter = head;
        while(iter != null){
            ListNode duplicate = iter;
            while(duplicate.next != null && duplicate.val == duplicate.next.val){
                duplicate = duplicate.next;
            }
            iter.next = duplicate.next;
            iter = iter.next;
        }
        return head;
    }
}