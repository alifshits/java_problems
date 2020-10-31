class Solution {
    public int findNumberOfLIS(int[] nums) {
        var res = 0;
        var longest = 1;
        var dp = new int[nums.length][2];
        
        for (var i = 0; i < nums.length; ++i) {
            dp[i][0] = dp[i][1] = 1;
            
            for (var j = i - 1; j >= 0; --j) {
                if (nums[i] > nums[j]) {
                    if (dp[i][0] < dp[j][0] + 1) {
                        dp[i][0] = dp[j][0] + 1;
                        dp[i][1] = dp[j][1];
                        longest = Math.max(longest, dp[i][0]);
                    }
                    else if (dp[i][0] == dp[j][0] + 1) {
                        dp[i][1] += dp[j][1];
                    }
                }
            }
        }
        
        for (var i = 0; i < nums.length; ++i) {
            if (dp[i][0] == longest) {
                res += dp[i][1];
            }
        }
        
        return res;
    }
}