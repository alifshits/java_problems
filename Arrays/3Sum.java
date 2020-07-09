class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        var result = new ArrayList<List<Integer>>();
        
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length - 2; i++) { 
            if (nums[i] > 0) break;
            
            if (i == 0 || nums[i] != nums[i - 1]) {
                var lo = i + 1;
                var hi = nums.length - 1;

                while (lo < hi) {
                    if (nums[i] + nums[lo] + nums[hi] == 0) {
                        result.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                        while (lo < hi && nums[lo] == nums[lo + 1]) ++lo;
                        while (lo < hi && nums[hi] == nums[hi - 1]) --hi;

                        ++lo;
                        --hi;
                    }                
                    else if (nums[i] + nums[lo] + nums[hi] > 0) {
                        while (lo < hi && nums[hi] == nums[hi - 1]) --hi;
                        --hi;
                    }
                    else { 
                        while (lo < hi && nums[lo] == nums[lo + 1]) ++lo;
                        ++lo;
                    }
                }    
            }
        }
        
        return result;
    }
}