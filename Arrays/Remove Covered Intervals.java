class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        var cnt = 0;
        for (var i = 0; i < intervals.length; ++i) {
            for (var j = 0; j < intervals.length; ++j) {
                if (i != j && intervals[i][0] >= intervals[j][0] && intervals[i][1] <= intervals[j][1]) {
                    ++cnt;
                    break;
                }
            }
        }
        
        return intervals.length - cnt;
    }
}