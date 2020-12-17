class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        var map = new HashMap<Integer, Integer>();
        var cnt = 0;
        
        for (var a : A) {
            for (var b : B) {
                var s = a + b;
                map.put(s, map.getOrDefault(s, 0) + 1);
            }
        }
        
        for (var c : C) {
            for (var d : D) {
                var s = c + d;
                cnt += map.getOrDefault(-1 * s, 0);
            }
        }
        
        return cnt;
    }
}