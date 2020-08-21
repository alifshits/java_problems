class Solution {
    public int[] sortArrayByParity(int[] A) {
        var res = new int[A.length];
        var i = 0;
        var j = res.length - 1;
        
        for (var n : A) {
            if ((n & 1) == 1) {
                res[j--] = n;
            }
            else {
                res[i++] = n;
            }
        }
        
        return res;
    }
}