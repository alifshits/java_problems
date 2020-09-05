class Solution {
    public List<Integer> partitionLabels(String S) {
        var res = new ArrayList<Integer>();
        var map = new int[26];
        
        for (var i = 0; i < S.length(); ++i) {
            map[S.charAt(i) - 'a'] = i;
        }
        
        var i = 0;
        var size = 0;
        var right = 0;
        
        while (i < S.length()) {
            var rightTmp = map[S.charAt(i) - 'a'];
            
            if (i <= right) {
                right = Math.max(right, rightTmp);
                ++size;
            } 
            else {
                res.add(size);
                right = rightTmp;
                size = 1;
            }

            ++i;
        }
        
        res.add(size);
        
        return res;
    }
}