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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        if (k == 0) {
            return head;
        }

        var list = new ArrayList<ListNode>();
        var tmp = head;

        while (tmp != null) {
            list.add(tmp);
            tmp = tmp.next;
        }

        k = k % list.size();
        if (k == 0) {
            return head;
        }

        head = list.get(list.size() - k);
        head.next = null;

        tmp = head;

        for (var i = list.size() - k + 1; i < list.size(); ++i) {
            tmp.next = list.get(i);
            tmp = tmp.next;
            tmp.next = null;
        }

        for (var i = 0; i < list.size() - k; ++i) {
            tmp.next = list.get(i);
            tmp = tmp.next;
            tmp.next = null;
        }

        return head;
    }
}