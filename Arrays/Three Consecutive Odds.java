class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        if (arr.length < 3) return false;
        
        var f = arr[0];
        var s = arr[1];
        
        for (var i = 2; i < arr.length; ++i) {
            if ((f & s & arr[i] & 1) == 1) {
                return true;
            }
            
            f = s;
            s = arr[i];
        }
        
        return false;
    }
}