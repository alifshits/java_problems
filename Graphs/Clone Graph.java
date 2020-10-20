/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        var map = new HashMap<Integer, Node>();
        return clone(node, map);
    }
    
    private static Node clone(Node node, HashMap<Integer, Node> map) {
        if (node == null) {
            return null;
        }
        
        var cloned = map.get(node.val);
        if (cloned != null) {
            return cloned;
        }
        
        cloned = new Node(node.val);
        
        map.put(node.val, cloned);
        
        if (node.neighbors != null) {
            for (var n : node.neighbors) {
                cloned.neighbors.add(clone(n, map));
            }
        }
        
        return cloned;
    }
}