class Solution {
    public int minFlips(String target) {
        var cnt = 0;
        var i = 0;
        
        while (i < target.length() && target.charAt(i) == '0') {
            ++i;
        }
        
        if (i == target.length()) return cnt;
        
        do {
            ++cnt;
            
            var flipped = cnt % 2 == 1 ? '1' : '0';
            while (i < target.length() && target.charAt(i) == flipped) {
                ++i;
            }
        }
        while (i < target.length());
        
        return cnt;
    }
}