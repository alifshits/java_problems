class Solution {
    public boolean repeatedSubstringPattern(String s) {
        for (var len = s.length() / 2; len >= 1; --len) {
            if (s.length() % len == 0) {
                var substr = s.substring(0, len);
                if (substr.repeat(s.length() / len).equals(s)) {
                    return true;
                }
            }
        }
        
        return false;
    }
}