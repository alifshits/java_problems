class Solution {
    public int numSub(String s) {
        var cnt = 0;
        var m = 1_000_000_000 + 7;
        var len = 0;
        
        for (var i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '1') {
                ++len;
                cnt = (cnt + len) % m;
            } else {
                len = 0;
            }
        }
        
        return cnt;
    }  
}