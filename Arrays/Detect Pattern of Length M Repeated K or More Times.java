class Solution {
    public boolean containsPattern(int[] arr, int m, int k) {        
        for (var i = arr.length - 1; i >= m - 1; --i) {
            var cnt = 1;
            var p = getPattern(arr, i, m);
            
            var j = i - m;
            
            while (j >= m - 1 && cnt < k) {
                if (isEqual(arr, p, j)) {
                    ++cnt;
                    j -= m;
                } 
                else {
                    // --j;
                    break;
                }                    
            }
            
            if (cnt == k) return true;
        }
        
        return false;
    }
    
    private static int[] getPattern(int[] arr, int i, int m) {
        var p = new int[m];
        
        for (int j = i, k = 0; j >= i - m + 1; --j, ++k) {
            p[m - k - 1] = arr[j];
        }
        
        return p;
    }
    
    private static boolean isEqual(int[] arr, int[] p, int i) {
        for (var j = 0; j < p.length; ++j) {
            if (p[p.length - 1 - j] != arr[i]) {
                return false;
            }
            
            --i;
        }
        
        return true;
    }
}