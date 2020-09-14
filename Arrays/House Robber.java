class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        
        var dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = nums[1];
        
        for (var i = 2; i < nums.length; ++i) {
            dp[i] = dp[i - 1];
            for (var j = i - 2; j >= 0; --j) {
                dp[i] = Math.max(dp[i], dp[j] + nums[i]);
            }            
        }
        
        return Math.max(dp[dp.length - 2], dp[dp.length - 1]);
    }
}