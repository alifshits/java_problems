class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        var set = new TreeSet<Long>();
        
        for (var i = 0; i <= Math.min(k, nums.length - 1); ++i) {
            long num = nums[i];
            if (!set.add(num)) {
                if (t >= 0) return true;
            }
        }
        
        Long prev = null;
        for (var n : set) {
            if (prev != null) {
                if (Math.abs(n - prev) <= t) return true;
            }
            
            prev = n;
        }
        
        for (var i = k + 1; i < nums.length; ++i) {
            set.remove((long)nums[i - k - 1]);
            set.add((long)nums[i]);
            
            var ss = set.subSet((long)nums[i] - t, true, (long)nums[i] + t, true);
            if (ss.size() >= 2) return true;
        } 
        
        return false;
    }
}