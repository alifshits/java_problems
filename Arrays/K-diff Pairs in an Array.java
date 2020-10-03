public class Solution {
    public int findPairs(int[] nums, int k) {
        var res = 0;
        
        if (k == 0) {
            var map = new HashMap<Integer, Integer>();
            for (var num : nums) {
                var cnt = map.getOrDefault(num, 0);
                map.put(num, cnt + 1);
                if (cnt == 1) {
                    ++res;
                }
            }
            
            return res;
        }
        
        var set = new HashSet<Integer>();
        for (var num : nums) {
            set.add(num);
        }
        
        for (var num : set) {
            var a = num;
            var b = k + a;
            
            if (set.contains(b)) {
                ++res;
            }
        }
        
        return res;
    }
}