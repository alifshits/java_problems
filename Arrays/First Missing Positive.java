class Solution {
    public int firstMissingPositive(int[] nums) {
        if (nums.length == 0) {
            return 1;
        }

        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

        for (var i = 0; i < nums.length; ++i) {
            if (nums[i] > 0) {
                min = Math.min(min, nums[i]);
                max = Math.max(max, nums[i]);
            }
            else {
                nums[i] = 0;
            }
        }

        if (min > 1) {
            return 1;
        }

        for (var i = 0; i < nums.length; ++i) {
            if (nums[i] == 0 || nums[i] == Integer.MIN_VALUE) {
                continue;
            }

            var num = Math.abs(nums[i]);
            if (num - min >= nums.length) {
                continue;
            }

            if (nums[num - min] == 0) {
                nums[num - min] = Integer.MIN_VALUE;
            }
            else if (nums[num - min] > 0){
                nums[num - min] *= -1;
            }
        }

        for (var i = min; i <= max; ++i) {
            if (i - min < nums.length) {
                if (nums[i - min] >= 0) {
                    return i;
                }
                else {
                    continue;
                }
            }

            return i - 1 - min;
        }

        return max + 1;
    }
}