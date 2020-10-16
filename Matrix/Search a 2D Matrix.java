class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) return false;
        
        var row = 0;
        var col = matrix[0].length - 1;
        
        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == target) {
                return true;
            }
            
            if (target < matrix[row][col]) {
                --col;
            }
            else {
                ++row;
            }
        }
        
        return false;
    }
}