class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        var result = new ArrayList<List<Integer>>();
        
        subsets(nums, 0, new ArrayList<Integer>(), result);
        
        return result;
    }
    
    private static void subsets(
        int[] nums, 
        int i, 
        ArrayList<Integer> current, 
        ArrayList<List<Integer>> result) {
        
        var subset = new ArrayList<Integer>(current);
        result.add(subset);
        
        for (; i < nums.length; ++i) {
            current.add(nums[i]);
            subsets(nums, i + 1, current, result);
            current.remove(current.size() - 1);
        }
    }
}

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        var result = new ArrayList<List<Integer>>();
        
        for (var i = 0; i < Math.pow(2, nums.length); ++i) {
            var subset = new ArrayList<Integer>();
            
            for (var j = 0; j < nums.length; ++j) {
                if ((i >> (nums.length - 1 - j) & 1) == 1) {
                    subset.add(nums[j]);
                }
            }
            
            result.add(subset);
        }
        
        return result;
    }
}