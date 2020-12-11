class Solution {
    public int removeDuplicates(int[] nums) {
        var start = 0;
        var end = nums.length - 1;
        var i = 1;
        
        while (i <= end) {
            if (nums[i] != nums[i - 1]) {
                start = i;
                ++i;
                continue;
            }
            
            if (i - start == 1) {
                ++i;
                continue;
            }
            
            for (var j = i; j < end; ++j) {
                var tmp = nums[j];
                nums[j] = nums[j + 1];
                nums[j + 1] = tmp;
            }
            
            --end;
        }
        
        return end + 1;
    }
}