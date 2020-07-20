class Solution {
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        var result = new int[n];
        var tree = getTree(edges, labels);
        
        for (var d = tree.maxDepth; d >= 0; --d) {
            var nodes = tree.nodes.get(d);
            if (nodes == null) continue;
            
            for (var node : nodes) {
                if (node.parent != null) {
                    merge(node.parent.map, node.map);
                }
                
                result[node.i] = node.map[labels.charAt(node.i) - 'a'];
            }
        }
        
        return result;
    }
    
    private Tree getTree(int[][] edges, String labels) {
        var q = new LinkedList<Node>();
        var visited = new HashSet<Integer>();
        var map = new HashMap<Integer, ArrayList<Integer>>();
        var maxDepth = 0;
        var nodes = new HashMap<Integer, ArrayList<Node>>();
        
        for (var edge : edges) {
            var list = map.get(edge[0]);
            if (list == null) {
                list = new ArrayList<Integer>();
                map.put(edge[0], list);
            }
            
            list.add(edge[1]);
            
            list = map.get(edge[1]);
            if (list == null) {
                list = new ArrayList<Integer>();
                map.put(edge[1], list);
            }
            
            list.add(edge[0]);
        }
        
        q.add(new Node(0, 0, labels.charAt(0), null));
        visited.add(0);
        
        while (q.size() > 0) {
            var node = q.poll();
            
            maxDepth = Math.max(maxDepth, node.depth);
            
            var nodesByDepth = nodes.get(node.depth);
            if (nodesByDepth == null) {
                nodesByDepth = new ArrayList<Node>();
                nodes.put(node.depth, nodesByDepth);
            }
            
            nodesByDepth.add(node);
            
            var neighbors = map.get(node.i);
            if (neighbors != null) {
                for (var n : neighbors) {
                    if (visited.add(n)) {
                        q.add(new Node(n, node.depth + 1, labels.charAt(n), node));
                    }
                }
            }
        }
        
        return new Tree(maxDepth, nodes);
    }
    
    private void merge(int[] parent, int[] child) {
        for (var i = 0; i < 26; ++i)
            parent[i] += child[i];
    }
    
    class Tree {
        public final int maxDepth;
        public final HashMap<Integer, ArrayList<Node>> nodes;
        
        public Tree(int maxDepth, HashMap<Integer, ArrayList<Node>> nodes) {
            this.maxDepth = maxDepth;
            this.nodes = nodes;
        }
    }
    
    class Node {
        public final int i;
        public final int depth;
        public final int[] map;
        public final Node parent;
        
        public Node(int i, int depth, char label, Node parent) {
            this.i = i;
            this.depth = depth;
            this.map = new int[26];
            this.map[label - 'a'] = 1;
            this.parent = parent;
        }
    }
}