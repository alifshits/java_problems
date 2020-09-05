class Solution {
    public int minDays(int[][] grid) {
        if (getIslandsCount(grid) != 1) {
            return 0;
        }
        
        var rows = grid.length;
        var cols = grid[0].length;
        
        for (var i = 0; i < rows; ++i) {
            for (var j = 0; j < cols; ++j) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 0;
                    
                    if (getIslandsCount(grid) != 1) {
                        return 1;
                    }
                    
                    grid[i][j] = 1;
                }
            }
        }
        
        return 2;
    }
    
    private static int getIslandsCount(int[][] grid) {
        var cnt = 0;
        var rows = grid.length;
        var cols = grid[0].length;
        var visited = new HashSet<Integer>();
        
        for (var i = 0; i < rows; ++i) {
            for (var j = 0; j < cols; ++j) {
                var coord = i * cols + j;
                if (grid[i][j] == 1 && !visited.contains(coord)) {
                    Explore(grid, coord, visited);
                    ++cnt;
                }
            }
        }
        
        return cnt;
    }
    
    private static void Explore(int[][] grid, int coord, HashSet<Integer> visited) {
        var q = new LinkedList<Integer>();     
        var rows = grid.length;
        var cols = grid[0].length;
        
        q.offer(coord);
        visited.add(coord);
        
        while (q.size() > 0) {
            var cell = q.poll();
            var r = cell / cols;
            var c = cell % cols;
            
            for (var d : dirs) {
                var newR = r + d[0];
                var newC = c + d[1];

                if (newR < 0 || newR == rows || newC < 0 || newC == cols) {
                    continue;
                }
                
                if (grid[newR][newC] != 1) {
                    continue;
                }
                
                var newCoord = newR * cols + newC;                
                
                if (visited.add(newCoord)) {
                    q.offer(newCoord);
                }
            }
        }
    }
    
    private static final int[][] dirs = {
        { 0, 1 },
        { 0, -1 },
        { 1, 0 },
        { -1, 0 }
    };
}