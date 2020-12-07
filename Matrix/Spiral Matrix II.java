class Solution {
    public int[][] generateMatrix(int n) {
        var res = new int[n][n];
        
        var startRow = 0; var endRow = n - 1;
        var startCol = 0; var endCol = n - 1;
        var x = 1;
        
        for (var i = 0; i < (n + 1) / 2; ++i) {
            for (var c = startCol; c <= endCol; ++c) {
                res[startRow][c] = x++;
            }
            
            for (var r = startRow + 1; r <= endRow; ++r) {
                res[r][endCol] = x++;
            }
            
            for (var c = endCol - 1; c >= startCol; --c) {
                 res[endRow][c] = x++;
            }
            
            for (var r = endRow - 1; r >= startRow + 1; --r) {
                 res[r][startCol] = x++;
            }
            
            ++startCol; ++startRow;
            --endCol; --endRow;
        }
        
        return res;
    }
}