class Solution {
    public int islandPerimeter(int[][] grid) {        
        var p = 0;
        
        for (var i = 0; i < grid.length; ++i) {
            for (var j = 0; j < grid[i].length; ++j) {
                if (grid[i][j] == 0) continue;
                
                if (i - 1 < 0 || grid[i - 1][j] == 0) ++p;
                if (i + 1 == grid.length || grid[i + 1][j] == 0) ++p;
                if (j - 1 < 0 || grid[i][j - 1] == 0) ++p;
                if (j + 1 == grid[i].length || grid[i][j + 1] == 0) ++p;
            }
        }
        
        return p;
    }
}