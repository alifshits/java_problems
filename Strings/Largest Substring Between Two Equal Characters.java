class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        var map = new int[26];
        var res = -1;
        
        Arrays.fill(map, -1); 
        
        for (var i = 0; i < s.length(); ++i) {
            var c = s.charAt(i) - 'a';
            if (map[c] == -1) {
                map[c] = i;
            }
            else {
                res = Math.max(res, i - map[c] - 1);
            }
        }
        
        return res;
    }
}