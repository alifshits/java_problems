class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        var gaps = new HashMap<Integer, Integer>();
        var maxGaps = 0;
        
        for (var row : wall) {
            var idx = 0;
            
            for (var i = 0; i < row.size() - 1; ++i) {
                idx += row.get(i);
                var cnt = gaps.getOrDefault(idx, 0);
                gaps.put(idx, cnt + 1);
            }
        }
        
        for (var gap : gaps.values()) {
            maxGaps = Math.max(maxGaps, gap);
        }
        
        return wall.size() - maxGaps;
    }
}