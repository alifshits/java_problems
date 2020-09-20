class Solution {
    private int max = 1;
    
    public int maxUniqueSplit(String s) {
        maxUniqueSplit(s, 0, new HashSet<String>());
        return max;
    }
    
    private void maxUniqueSplit(String s, int i, HashSet<String> current) {
        if (i == s.length()) {
            max = Math.max(max, current.size());
            return;
        }
        
        for (var len = 1; len <= s.length() - i; ++len) {
            var sub = s.substring(i, i + len);
            if (current.add(sub)) {
                maxUniqueSplit(s, i + len, current);
                current.remove(sub);
            }
        }
    }
}