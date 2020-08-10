class Solution {
    public char findKthBit(int n, int k) {
        var sb = new StringBuilder((int)Math.pow(2, n) - 1);
        sb.append('0');
        
        while (sb.length() < k) {
            var sbTmp = new StringBuilder(sb.length());
            for (var i = 0; i < sb.length(); ++i) {
                sbTmp.append(sb.charAt(i) == '0' ? '1' : '0');
            }
            
            sb.append('1');
            sb.append(sbTmp.reverse().toString());
        }
        
        return sb.charAt(k - 1);
    }
}