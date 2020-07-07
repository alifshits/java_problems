class Solution {
    public int countLargestGroup(int n) {
        var map = new HashMap<Integer, Integer>();
        var maxSize = Integer.MIN_VALUE;
        var cnt = 0;
        
        for (var i = 1; i <= n; ++i) {
            var sum = 0;
            var tmp = i;
            
            while (tmp != 0) {
                sum += tmp % 10;
                tmp /= 10;
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);
            maxSize = Math.max(maxSize, map.get(sum));
        }
        
        for (var size : map.values()) {
            if (size == maxSize)
                ++cnt;
        }
        
        return cnt;
    }
}