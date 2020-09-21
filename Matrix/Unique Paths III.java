class Solution {
    public int uniquePathsIII(int[][] grid) {
        int cnt = 0;
        int rows = grid.length, cols = grid[0].length;
        int emptyCells = 0;
        int startR = -1, startC = -1;
        
        for (var i = 0; i < rows; ++i) {
            for (var j = 0; j < cols; ++j) {
                if (grid[i][j] == 1) {
                    startR = i;
                    startC = j;
                }
                else if (grid[i][j] == 0) {
                    ++emptyCells;
                }
            }
        }

        var q = new LinkedList<Step>();   
        var firstStep = new Step(startR, startC, rows, cols, emptyCells);
        firstStep.visited[startR][startC] = true;
        q.offer(firstStep);
        
        while (q.size() > 0) {
            var step = q.poll();
            if (grid[step.r][step.c] == 2) {
                if (step.emptyCells == 0) {
                    ++cnt;
                }
                
                continue;
            }
            
            for (var dir : dirs) {
                var r = step.r + dir[0];
                var c = step.c + dir[1];
                
                if (r < 0 || r == rows || c < 0 || c == cols) {
                    continue;
                }
                
                if (grid[r][c] == -1) {
                    continue;
                }
                
                if (step.visited[r][c]) {
                    continue;
                }
                
                var nextEmptyCells = grid[r][c] == 0 ? step.emptyCells - 1 : step.emptyCells;
                
                var nextVisited = new boolean[rows][cols];
                copy(step.visited, nextVisited);
                nextVisited[r][c] = true;
                    
                var nextStep = new Step(r, c, nextVisited, nextEmptyCells);
                q.offer(nextStep);
            }
        }
        
        return cnt;
    }
    
    public static void copy(boolean[][] source, boolean[][] dest) {
        for (var i = 0; i < source.length; ++i) {
            System.arraycopy(source[i], 0, dest[i], 0, source[i].length);
        }
    }
    
    private static final class Step {
        public final int r;
        public final int c;
        public final int emptyCells;
        public final boolean[][] visited;
            
        public Step(int r, int c, int rows, int cols, int emptyCells) {
            this.r = r;
            this.c = c;
            this.visited = new boolean[rows][cols];
            this.emptyCells = emptyCells;
        }
        
        public Step(int r, int c, boolean[][] visited, int emptyCells) {
            this.r = r;
            this.c = c;
            this.visited = visited;
            this.emptyCells = emptyCells;
        }
    }
    
    private static final int[][] dirs = new int[][] {
        { 0, 1 },
        { 1, 0 },
        { 0, -1 },
        { -1, 0 }
    };
}