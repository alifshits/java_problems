class Solution {
    public int longestSubstring(String s, int k) {
        var res = 0;
        
        for (var str : splitString(s, k)) {
            res = Math.max(res, str.length());
        }
        
        return res;   
    }
    
    private static ArrayList<String> splitString(String s, int k) {     
        var res = new ArrayList<String>();
        var map = new int[26];
        
        for (var i = 0; i < s.length(); ++i) {
            map[s.charAt(i) - 'a'] += 1;
        }
        
        var sb = new StringBuilder(52);
        for (var i = 0; i < map.length; ++i) {
            if (map[i] > 0 && map[i] < k) {
                sb.append((char)(i + 'a'));
                sb.append('|');
            }
        }
        
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
        }
        
        if (sb.length() == 0) {
            res.add(s);
        }
        else {
            var parts = s.split(sb.toString());
            for (var p : parts) {
                if (p.length() > 0) {
                    res.addAll(splitString(p, k));
                }
            }
        }
        
        return res;
    }
}