class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        var res = 0;
        var map = new HashMap<Integer, Integer>();
        var sums = new ArrayList<Integer>();
        
        for (var i = 60; i <= 1000; i += 60) {
            sums.add(i);
        }
        
        for (var t : time) {
            var cnt = map.getOrDefault(t, 0);
            map.put(t, cnt + 1);
        }
        
        for (var entry : map.entrySet()) {
            var a = entry.getKey();
            var cntA = entry.getValue();
            
            for (var sum : sums) {
                var b = sum - a;
                if (b < a) {
                    continue;
                }
                
                var cntB = map.get(b);
                if (cntB == null) {
                    continue;
                }
               
                if (a != b) {
                    res += cntA * cntB;
                }
                else {
                    res += (cntA - 1) * cntA / 2;
                }
            }
        }
        
        return res;
    }
}