class Solution {
    public int maxPower(String s) {
        var res = 1;
        var prev = s.charAt(0);
        var curr = 1;
        
        for (var i = 1; i < s.length(); ++i) {
            var c = s.charAt(i);
            if (c == prev) {
                ++curr;
                res = Math.max(res, curr);
            }
            else {
                curr = 1;
                prev = c;
            }
        }
        
        return res;
    }
}