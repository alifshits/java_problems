class Solution {
    public int findMinFibonacciNumbers(int k) {
        if (k <= 1) return 1;
        
        int n2 = 1, n1 = 1;
        var nums = new ArrayList<Integer>(64);
        
        nums.add(1);
        nums.add(1);
        
        while (true) {
            var sum = n2 + n1;
            nums.add(sum);
            
            if (sum >= k) break;
            
            n2 = n1;
            n1 = sum;
        }
        
        return count(nums, k, nums.size() - 1);
    }
    
    private static int count(ArrayList<Integer> nums, int k, int start) {
        if (k == 0) return 0;
        
        var i = start;
        for (; i >= 0; --i) {
            if (nums.get(i) <= k) {
                break;
            }
        }
        
        k -= nums.get(i);
        
        return 1 + count(nums, k, i - 1);
    }
}