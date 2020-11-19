class Solution {
    private int i;
    
    public String decodeString(String s) {
        i = 0;
        return decodeStringInternal(s).toString();
    }
    
    private StringBuilder decodeStringInternal(String s) {
        var sb = new StringBuilder();
        
        while (i < s.length()) {            
            while (i < s.length() && s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
                sb.append(s.charAt(i));
                ++i;
            }

            var cnt = 0;
            while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                cnt = cnt * 10 + (s.charAt(i) - '0');
                ++i;
            }

            if (cnt > 0) {
                ++i;
                var inner = decodeStringInternal(s).toString();
                for (var x = 0; x < cnt; ++x) {
                    sb.append(inner);
                }
            }
            
            if (i < s.length() && s.charAt(i) == ']') {
                ++i;
                return sb;
            }
        }
        
        return sb;
    }
}