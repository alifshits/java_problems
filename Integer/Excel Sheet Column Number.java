class Solution {
    public int titleToNumber(String s) {
        var sum = 0;        
        
        for (var i = 0; i < s.length(); ++i) {
            var pow = s.length() - 1 - i;
            sum += (s.charAt(i) - 'A' + 1) * Math.pow(26, pow);
        }
        
        return sum;
    }
}