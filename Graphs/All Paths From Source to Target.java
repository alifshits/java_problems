class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        var result = new ArrayList<List<Integer>>();
        var visited = new boolean[graph.length];
        var map = new HashMap<Integer, ArrayList<Integer>>();
        var path = new ArrayList<Integer>();
        
        for (var i = 0; i < graph.length; ++i) {
            for (var v : graph[i]) {
                var lst = map.computeIfAbsent(i, k -> new ArrayList<Integer>());
                lst.add(v);
            }
        }
        
        visited[0] = true;
        path.add(0);
        go(0, graph.length - 1, path, visited, map, result);
        
        return result;
    }
    
    private static void go(
        int node, 
        int target, 
        ArrayList<Integer> path, 
        boolean[] visited,
        HashMap<Integer, ArrayList<Integer>> map,
        ArrayList<List<Integer>> result) {
        
        if (node == target) {
            result.add((ArrayList<Integer>)path.clone());
            return;
        }
        
        var lst = map.get(node);
        if (lst != null) {
            for (var next : lst) {
                if (visited[next]) continue;
                
                visited[next] = true;
                path.add(next);
                
                go(next, target, path, visited, map, result);
                
                path.remove(path.size() - 1);
                visited[next] = false;
            }
        }
    }
}