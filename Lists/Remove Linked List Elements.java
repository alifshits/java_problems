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
    public ListNode removeElements(ListNode head, int val) {         
        while (head != null && head.val == val) {
            head = head.next;
        }
        
        if (head == null) return null;
        
        var prev = head;
        var tmp = head.next;
        
        while (tmp != null) {
            if (tmp.val == val) {
                prev.next = tmp.next;
            } else {
                prev = tmp;
            }
            
            tmp = tmp.next;
        }
        
        return head;
    }
}