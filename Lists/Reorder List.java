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
        if (head == null) return;
        
        var stack = new Stack<ListNode>();
        var tmp = head;
        
        while (tmp != null) {
            stack.push(tmp);
            tmp = tmp.next;
        }
        
        var cnt = stack.size();
        tmp = head;
        
        for (var i = 0; i < cnt / 2; ++i) {
            var x = stack.pop();
            
            var next = tmp.next;
            tmp.next = x;
            x.next = next;
        
            tmp = next;        
        }
        
        tmp.next = null;
    }
}