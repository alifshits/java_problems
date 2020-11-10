class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        for (var i = 0; i < A.length; ++i) {
            var mid = A[i].length >> 1;
            
            for (var j = 0; j < mid; ++j) {
                var x = A[i][j] ^ 1;
                var y = A[i][A[i].length - 1 - j] ^ 1;
                
                A[i][j] = y;
                A[i][A[i].length - 1 - j] = x;
            }
            
            if ((A[i].length & 1) == 1) {
                A[i][mid] = A[i][mid] ^ 1;
            }
        }
        
        return A;
    }
}