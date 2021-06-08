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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        ListNode fast = head;
        ListNode slow = head;
        ListNode preMid = null;
        // finds the mid element
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            preMid = slow;
            slow = slow.next;
        }
        
        // if there's only one node
        if(fast == slow){
            return new TreeNode(slow.val);
        }
        
        TreeNode cur = new TreeNode(slow.val);
        preMid.next = null;
        cur.left = sortedListToBST(head);
        cur.right = sortedListToBST(slow.next);
        return cur;
    }
}