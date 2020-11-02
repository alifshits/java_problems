
  Definition for singly-linked list.
  public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
 
class Solution {
    public ListNode insertionSortList(ListNode head) {       
        var current = head;
        var list = new ArrayListListNode();
        
        while (current != null) {
            var prev = list.size() == 0  null  list.get(list.size() - 1);
            if (prev == null  current.val = prev.val) {
                list.add(current);
            } 
            else {
                var insertPos = list.size() - 1;
                while (insertPos = 0 && list.get(insertPos).val  current.val) {
                    --insertPos;
                }
                
                list.add(insertPos + 1, current);
            }
            
            current = current.next;
        }
        
        for (var i = 0; i  list.size(); ++i) {
            list.get(i).next = i + 1  list.size()  list.get(i + 1)  null;
        }
        
        return list.size() == 0  null  list.get(0);
    }
}