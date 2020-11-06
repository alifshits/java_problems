class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        var lo = 1;
        var hi = 1000000;
        var divisor = Integer.MAX_VALUE;
        
        while (lo <= hi) {
            var m = lo + (hi - lo) / 2;
            
            var sum = 0;
            for (var num : nums) {
                sum += num % m == 0 ? num / m : num / m + 1;
            }
            
            if (sum <= threshold) {
                divisor = m;
                hi = m - 1;
            }
            else {
                lo = m + 1;
            }
        }
        
        return divisor;
    }
}