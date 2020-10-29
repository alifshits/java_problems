/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        var slow = head;
        var fast = head;
        
        while (fast != null) {           
            slow = slow.next;
            fast = fast.next != null ? fast.next.next : null;
            
            if (slow == fast) {
                break;
            }
        }
        
        if (fast == null) {
            return null;
        }
        
        var ptr2 = slow;
        
        while (head != ptr2) {
            head = head.next;
            ptr2 = ptr2.next;
        }
        
        return head;
    }
}