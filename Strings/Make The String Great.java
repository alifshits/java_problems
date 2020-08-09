class Solution {
    public String makeGood(String str) {
        var sb = new StringBuilder(str);
        
        while (true) {
            var found = false;
            
            var i = 0;
            while (i < sb.length() - 1) {
                var f = sb.charAt(i);
                var s = sb.charAt(i + 1);
                
                if (f == s - 32 || f - 32 == s) {
                    sb.delete(i, i + 2);
                    found = true;
                } else {
                    ++i;
                }
            }
            
            if (!found) break;
        }
        
        return sb.toString();
    }
}