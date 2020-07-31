class Solution {
    public int climbStairs(int n) {
        var dp = new int[Math.max(n, 2)];
        dp[0] = 1;
        dp[1] = 1;
        
        for (var i = 1; i < n; ++i) {
            for (var j = 1; j <= 2 && i - j >= 0; ++j) {
                dp[i] += dp[i - j];
            }            
        }
        
        return dp[n - 1];
    }
}