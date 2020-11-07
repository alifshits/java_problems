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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        var s1 = new Stack<Integer>();
        var s2 = new Stack<Integer>();
        var s3 = new Stack<Integer>();
        
        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        
        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }
        
        var carry = false;
        while (s1.size() > 0 && s2.size() > 0) {
            var x = s1.pop();
            var y = s2.pop();
            var z = x + y + (carry ? 1 : 0);
            
            carry = z > 9;
            s3.push(z % 10);
        }
        
        while (s1.size() > 0) {
            var x = s1.pop();
            var z = x + (carry ? 1 : 0);
            carry = z > 9;
            s3.push(z % 10);
        }
        
        while (s2.size() > 0) {
            var y = s2.pop();
            var z = y + (carry ? 1 : 0);
            carry = z > 9;
            s3.push(z % 10);
        }
        
        if (carry) {
            s3.push(1);
        }
        
        ListNode res = null, curr = null;
        
        while (s3.size() > 0) {
            var tmp = new ListNode(s3.pop());
            if (res == null) {
                res = curr = tmp;
            }
            else {
                curr.next = tmp;
                curr = tmp;
            }
        }
        
        return res;
    }
}