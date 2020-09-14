class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        var res = new ArrayList<int[]>(intervals.length + 1);
        if (intervals.length == 0) {
            res.add(newInterval);
            return res.toArray(new int[0][]);
        }
        
        var wasMerged = false;
        
        for (var i = 0; i < intervals.length; ++i) {
            if (res.size() > 0) {
                var last = res.get(res.size() - 1);
                if (intervals[i][0] <= last[1]) {
                    last[1] = Math.max(intervals[i][1], last[1]);
                    continue;
                }
            }
            
            if (!wasMerged) {  
                if (newInterval[1] < intervals[i][0]) {
                    res.add(newInterval);
                    res.add(intervals[i]);
                    wasMerged = true;
                    continue;
                }
                
                if (newInterval[0] > intervals[i][1]) {
                    res.add(intervals[i]);
                    continue;
                }

                var merged = new int[] { 
                    Math.min(intervals[i][0], newInterval[0]), 
                    Math.max(intervals[i][1], newInterval[1])
                };

                res.add(merged);
                
                wasMerged = true;
            }
            else {
                res.add(intervals[i]);
            }
        }
        
        if (!wasMerged) {
            res.add(newInterval);
        }
        
        return res.toArray(new int[res.size()][]);
    }
}