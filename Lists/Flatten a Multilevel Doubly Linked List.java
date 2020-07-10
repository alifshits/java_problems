/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        var tmp = head;
        
        while (tmp != null) {
            if (tmp.child != null) {
                var next = tmp.next;
                
                var flatted = flatten(tmp.child); 
                
                tmp.child = null;
                tmp.next = flatted;
                if (flatted != null) {
                    flatted.prev = tmp;
                }
                
                Node lastFlatted = flatted;
                while (lastFlatted.next != null) {
                    lastFlatted = lastFlatted.next;
                }
                
                if (next != null) {
                    lastFlatted.next = next;
                    next.prev = lastFlatted;
                }
                
                tmp = lastFlatted;
            }
            
            tmp = tmp.next;
        }
        
        return head;
    }
}