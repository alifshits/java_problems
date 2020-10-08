class Solution {
    public int search(int[] nums, int target) {
        var lo = 0;
        var hi = nums.length - 1;
        
        while (lo <= hi) {
            var m = lo + (hi - lo) / 2;
            if (nums[m] == target) {
                return m;
            }
            
            if (nums[m] > target) {
                hi = m - 1;
            }
            else {
                lo = m + 1;
            }
        }
        
        return -1;
    }
}