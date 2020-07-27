class Solution {
    public String reverseWords(String s) {
        var parts = s.split(" ");
        var sb = new StringBuilder();
        
        for (var i = parts.length - 1; i >= 0; --i) {
            if (parts[i].length() > 0)
                sb.append(parts[i] + " ");
        }
        
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
        }
        
        return sb.toString();
    }
}