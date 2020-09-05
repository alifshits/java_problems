class Solution {
    private int len;
    
    public int getMaxLen(int[] nums) {
        len = 0;
        getMaxLen(nums, true);
        getMaxLen(nums, false);
        return len;
    }
    
    private void getMaxLen(int[] nums, boolean forward) {
        int currLen = 0, lastNegativeIdx = -1, lastNegativeLen = -1;   
        int start = forward ? 0 : nums.length - 1, end = forward ? nums.length : -1, step = forward ? 1 : -1;
        
        for (var i = start; i != end; i += step) {
            if (nums[i] == 0) {
                currLen = 0;
                lastNegativeIdx = lastNegativeLen = -1;
                continue;
            }
            
            if (nums[i] > 0) {
                ++currLen;
                len = Math.max(len, currLen);
            }
            else {
                if (lastNegativeLen == -1) {
                    lastNegativeLen = currLen;
                    lastNegativeIdx = i;
                    currLen = 0;
                }
                else {
                    currLen += lastNegativeLen + 2;
                    len = Math.max(len, currLen);
                    lastNegativeIdx = lastNegativeLen = -1;
                }
            }
        }
    }
}