class Solution {
    public int[] findRightInterval(int[][] intervals) {
        var res = new int[intervals.length];
        var map = new HashMap<Integer, Integer>(intervals.length);

        for (var i = 0; i < intervals.length; ++i) {
            map.put(intervals[i][0], i);
        }

        var starts = Arrays.stream(intervals)
                .map(i -> i[0])
                .sorted()
                .collect(Collectors.toList());

        for (var i = 0; i < intervals.length; ++i) {
            var idx = Collections.binarySearch(starts, intervals[i][1]);
            if (idx < 0) {
                idx = -1 * (idx + 1);
            }

            res[i] = idx < intervals.length ? map.get(starts.get(idx)) : -1;
        }

        return res;
    }
}