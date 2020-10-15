class Solution {
    public void rotate(int[] nums, int k) {
        if (nums.length <= 1) {
            return;
        }
        
        k = k % nums.length;
        if (k == 0) {
            return;
        }
        
        var count = 0;
        
        for (var i = 0; count < nums.length; ++i) {
            var prev = nums[i];
            var prevIdx = i;
            
            do {
                var nextIdx = (prevIdx + k) % nums.length;
            
                var tmp = nums[nextIdx];
                nums[nextIdx] = prev;
            
                prev = tmp;
                prevIdx = nextIdx;
                
                ++count;
            } 
            while (prevIdx != i);
        }
    }
}