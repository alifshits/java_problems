class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        
        var opt1 = robInternal(IntStream.of(nums).skip(1).toArray());
        var opt2 = robInternal(IntStream.of(nums).limit(nums.length - 1).toArray());
        
        return Math.max(opt1, opt2);
    }   
    
    private static int robInternal(int[] nums) 
    {
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        
        var dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = nums[1];
        
        for (var i = 2; i < nums.length; ++i)
        {           
            var opt1 = dp[i - 2] + nums[i];
            var opt2 = dp[i - 1];
            var opt3 = i - 3 >= 0 ? dp[i - 3] + nums[i] : 0;
                     
            dp[i] = Math.max(opt1, Math.max(opt2, opt3));
        }
        
        return dp[dp.length - 1];
    }
}