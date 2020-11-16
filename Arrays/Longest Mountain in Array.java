class Solution {
    public int longestMountain(int[] A) {
        var res = 0;
        var inc = 0;
        var dec = 0;       
        var decreased = false;
        
        for (var i = 1; i < A.length; ++i) {
            if (A[i] > A[i - 1]) {
                if (decreased) {
                    inc = 1;
                    decreased = false;
                } 
                else {
                    ++inc; 
                }
                
                dec = 0;
            }
            else if (A[i] == A[i - 1]) {
                inc = 0;
                dec = 0;
            }
            else {
                ++dec;
                decreased = true;

                if (inc > 0 && dec > 0) {
                    var len = inc + dec + 1;
                    res = Math.max(res, len);
                }
            }
        }
        
        return res;
    }
}