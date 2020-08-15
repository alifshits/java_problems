class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;
        
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[1] != b[1]) {
                    return Integer.compare(a[1], b[1]);
                }
                
                return Integer.compare(a[0], b[0]);
            }
        });
        
        var cnt = 0;
        var prev = intervals[0];
        for (var i = 1; i < intervals.length; ++i) {
            if (prev[1] > intervals[i][0]) {
                ++cnt;
            } else {
                prev = intervals[i];
            }
        }
        
        return cnt;
    }
}