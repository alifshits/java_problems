class Solution {
    public int orangesRotting(int[][] grid) {
        var q = new LinkedList<Cell>();
        var visited = new HashSet<Cell>();
        var freshCnt = 0;
        
        for (var i = 0; i < grid.length; ++i) {
            for (var j = 0; j < grid[i].length; ++j) {
                if (grid[i][j] == 2) {
                    var c = new Cell(i, j);
                    q.add(c);
                    visited.add(c);
                } 
                else if (grid[i][j] == 1) {
                    ++freshCnt;
                }
            }
        }
               
        var t = 0;
        
        while (freshCnt > 0) {
            q = run(grid, q);
            if (q.size() == 0) break;
            
            freshCnt -= q.size();
            ++t;
        }
        
        return freshCnt > 0 ? -1 : t;
    }
    
    private static LinkedList<Cell> run(int[][] grid, LinkedList<Cell> q) {
        var res = new LinkedList<Cell>();
        
        while (q.size() > 0) {
            var cell = q.pop();

            for (var d : dirs) {
                var r = cell.r + d[0];
                var c = cell.c + d[1];

                if (r < 0 || r == grid.length || c < 0 || c == grid[r].length) {
                    continue;
                }

                if (grid[r][c] == 1) {
                    grid[r][c] = 2;
                    res.add(new Cell(r, c));
                }               
            }
        }
        
        return res;
    }
    
    private static final int[][] dirs = new int[][] {
        new int[] { 0, 1 },
        new int[] { 0, -1 },
        new int[] { 1, 0 },
        new int[] { -1, 0 }
    };
    
    private static final class Cell {
        public final int r;
        public final int c;
        
        public Cell(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}