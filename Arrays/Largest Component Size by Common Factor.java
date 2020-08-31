class Solution {
    public int largestComponentSize(int[] A) {
        var dsu = new DisjointSetUnion(100001);
        var res = 0;
        var map = new HashMap<Integer, Integer>();

        for (var num : A) {
            var factors = getFactors(num);

            for (var f : factors) {
                dsu.union(num, f);
                dsu.union(num, num / f);
            }
        }

        for (var num : A) {
            var parent = dsu.find(num);
            var cnt = map.getOrDefault(parent, 0) + 1;
            map.put(parent, cnt);

            res = Math.max(res, cnt);
        }

        return res;
    }

    private static ArrayList<Integer> getFactors(int num) {
        var res = new ArrayList<Integer>();

        for (var i = 2; i <= (int)Math.sqrt(num); ++i) {
            if (num % i == 0) {
                res.add(i);
            }
        }

        return res;
    }

    private static final class DisjointSetUnion
    {
        private final int[] parent;
        private final int[] rank;

        public DisjointSetUnion(int size)
        {
            parent = new int[size];
            rank = new int[size];

            for (var i = 0; i < parent.length; ++i) {
                parent[i] = i;
            }
        }

        public int find(int x)
        {
            if (parent[x] != x) parent[x] = find(parent[x]);
            return parent[x];
        }

        public boolean union(int x, int y)
        {
            var xr = find(x);
            var yr = find(y);

            if (xr == yr) return false;

            if (rank[xr] < rank[yr])
            {
                parent[xr] = yr;
            }
            else if (rank[xr] > rank[yr])
            {
                parent[yr] = xr;
            }
            else
            {
                parent[yr] = xr;
                rank[xr]++;
            }

            return true;
        }
    }
}