class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        var result = new ArrayList<String>();
        var letters = new int[s.length()];
        var starts = new int[26];
        var ends = new int[26];
        var intervals = new ArrayList<Interval>();

        Arrays.fill(starts, -1);

        for (var i = 0; i < s.length(); ++i) {
            letters[i] = s.charAt(i) - 'a';
            ends[letters[i]] = i;
        }

        for (var i = s.length() - 1; i >= 0; --i) {
            starts[letters[i]] = i;
        }

        for (var i = 0; i < 26; ++i) {
            var start = starts[i];
            if (start == -1) continue;

            var end = ends[i];

            for (var j = start; j <= end; ++j) {
                start = Math.min(start, starts[letters[j]]);
                end = Math.max(end, ends[letters[j]]);
            }

            if (start == starts[i])
                intervals.add(new Interval(start, end));
        }

        Collections.sort(intervals, Comparator.comparing(i -> i.end));

        var prev = -1;
        for (var i : intervals) {
            if (i.start > prev) {
                result.add(s.substring(i.start, i.end + 1));
                prev = i.end;
            }
        }

        return result;
    }

    class Interval {
        public final int start;
        public final int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}