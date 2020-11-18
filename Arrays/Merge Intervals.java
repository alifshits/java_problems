class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (i1, i2) -> i1[0] == i2[0] ? i1[1] - i2[1] : i1[0] - i2[0]);
        
        var res = new ArrayList<int[]>();
        
        var prev = intervals[0];
        
        for (var i = 1; i < intervals.length; ++i) {
            var curr = intervals[i];
            if (prev[1] < curr[0]) {
                res.add(prev);
                prev = curr;
                continue;
            }
            
            prev[1] = Math.max(prev[1], curr[1]);
        }
        
        res.add(prev);
        
        var arr = new int[res.size()][];
        for (var i = 0; i < res.size(); ++i) {
            arr[i] = res.get(i);
        }
        
        return arr;
    }
}