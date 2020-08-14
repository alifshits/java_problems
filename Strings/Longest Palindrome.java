class Solution {
    public int longestPalindrome(String s) {
        var len = 0;
        var map = new int[64];
        for (var i = 0; i < s.length(); ++i) {
            var c = s.charAt(i);
            map[c - 'A'] += 1;
        }
        
        var hasOdd = false;
        
        for (var i = 0; i < map.length; ++i) {            
            len += map[i];
            if ((map[i] & 1) == 1) {
                hasOdd = true;
                --len;
            }
        }
        
        if (hasOdd) {
            len += 1;
        }
        
        return len;
    }
}