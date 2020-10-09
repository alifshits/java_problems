class Solution {
    public int specialArray(int[] nums) {
        for (var i = 1; i <= 1000; ++i) {
            var cnt = 0;
            for (var num : nums) {
                if (num >= i) {
                    ++cnt;
                }
                
                if (cnt > i) {
                    break;
                }
            }
            
            if (cnt == i) {
                return i;
            }
        }
        
        return -1;
    }
}