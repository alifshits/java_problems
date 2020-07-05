class Solution {
    public int nthUglyNumber(int n) {
        var q = new PriorityQueue<Long>();
        var set = new HashSet<Long>();
        var result = 1l;

        q.offer(result);
        set.add(result);

        for (var i = 1; i <= n; ++i) {
            result = q.poll();
            if (set.add(result * 2)) q.offer(result * 2);
            if (set.add(result * 3)) q.offer(result * 3);
            if (set.add(result * 5)) q.offer(result * 5);
        }

        return (int)result;
    }
}