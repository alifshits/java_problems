class Solution {
    public List<String> summaryRanges(int[] nums) {
        var res = new ArrayList<String>();
        
        if (nums.length == 0) {
            return res;
        }
        
        var start = nums[0];
        
        for (var i = 1; i < nums.length; ++i) {
            if (nums[i] > nums[i - 1] + 1) {
                res.add(format(start, nums[i - 1]));
                start = nums[i];
            }
        }
        
        res.add(format(start, nums[nums.length - 1]));
        
        return res;
    }
    
    private static String format(int start, int end) {
        if (start != end) {
            return start + "->" + end;
        }
        
        return String.valueOf(start);
    }
}