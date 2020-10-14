class Solution {
    public boolean buddyStrings(String A, String B) {
        if (A.length() != B.length()) {
            return false;
        }
        
        var sbA = new StringBuilder(A);
        var set = new int[26];
        var hasDups = false;
        var firstIdx = -1;
        var secondIdx = -1;
        
        for (var i = 0; i < sbA.length(); ++i) {
            var a = sbA.charAt(i);
            var b = B.charAt(i);
            
            if (set[a - 'a'] > 0) {
                hasDups = true;
            }
            
            set[a - 'a']++;
            
            if (a != b) {
                if (firstIdx == -1) {
                    firstIdx = i;
                }
                else {
                    secondIdx = i; 
                    break;
                }
            }
        }  
        
        if (firstIdx == -1 && secondIdx == -1) {
            return hasDups;
        }
        
        if (secondIdx == -1) {
            return false;
        }
        
        var tmp = sbA.charAt(firstIdx);
        sbA.setCharAt(firstIdx, sbA.charAt(secondIdx));
        sbA.setCharAt(secondIdx, tmp);
        
        return sbA.toString().equals(B);        
    }
}