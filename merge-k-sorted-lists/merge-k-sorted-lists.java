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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        int left = 0;
        int right = lists.length - 1;            
        while(right != 0){
            while(left < right){
                ListNode leftNode = lists[left];
                ListNode rightNode = lists[right];
                lists[left] = merge(leftNode, rightNode);
                left++;
                right--;
            }
            left = 0;
        }
        return lists[0];
    }
    public ListNode merge(ListNode l1, ListNode l2){
        ListNode m = new ListNode(0);
        ListNode dummy = m;
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                dummy.next = new ListNode(l1.val);
                l1 = l1.next;
                dummy = dummy.next;
            }else{
                dummy.next = new ListNode(l2.val);
                l2 = l2.next;
                dummy = dummy.next;
            }
        }
        dummy.next = l1 == null ? l2 : l1;
        return m.next;
    }
}