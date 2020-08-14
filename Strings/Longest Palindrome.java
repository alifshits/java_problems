class Solution {
    public int longestPalindrome(String s) {
        var len = 0;
        var map = new HashMap<Character, Integer>();
        for (var i = 0; i < s.length(); ++i) {
            var c = s.charAt(i);
            var cnt = map.getOrDefault(c, 0);
            map.put(c, cnt + 1);
        }
        
        var hasOdd = false;
        
        for (var cnt : map.values()) {            
            len += cnt;
            if ((cnt & 1) == 1) {
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