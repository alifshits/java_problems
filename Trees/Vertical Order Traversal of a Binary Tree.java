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
    private int min;
    private int max;
    private HashMap<Integer, TreeSet<Node>> map;
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;        
        map = new HashMap<Integer, TreeSet<Node>>();
        
        Traverse(root, 0, 0);
        
        var result = new ArrayList<List<Integer>>();
        
        for (var i = min; i <= max; ++i) {
            var set = map.get(i);
            var list = new ArrayList<Integer>();
            
            for (var node : set) {
                list.add(node.val);
            }
            
            result.add(list);
        }
        
        return result;
    }
    
    private void Traverse(TreeNode root, int x, int y) {
        if (root == null) return;
        
        min = Math.min(min, x);
        max = Math.max(max, x);
        
        var set = map.computeIfAbsent(x, key -> new TreeSet<Node>());
        
        set.add(new Node(root.val, y));
        
        Traverse(root.left, x - 1, y + 1);
        Traverse(root.right, x + 1, y + 1);
    }
    
    private final class Node implements Comparable<Node> {
        public final int val;
        public final int y;
        private final int hashCode;
        
        public Node(int val, int y) {
            this.val = val;
            this.y = y;
            this.hashCode = Objects.hash(val, y);
        }
        
        @Override 
        public boolean equals(Object other) {
            Node otherNode = (Node) other;
            return val == otherNode.val && y == otherNode.y;
        }

        @Override 
        public int hashCode() {
            return hashCode;
        }

        @Override 
        public int compareTo(Node other) {
            if (y != other.y) {
                return y - other.y;
            }
            
            return val - other.val;
        }
    }
}