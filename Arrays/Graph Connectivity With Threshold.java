class Solution {
    public List<Boolean> areConnected(int n, int threshold, int[][] queries) {
        var res = new ArrayList<Boolean>(queries.length);
        var dsu = new DisjointSetUnion(n);
        var divisorToCity = new HashMap<Integer, ArrayList<Integer>>();

        for (var i = 0; i < n; ++i) {
            var divisors = getDivisors(i + 1, threshold);

            for (var divisor : divisors) {
                var cities = divisorToCity.computeIfAbsent(divisor, k -> new ArrayList<Integer>());
                cities.add(i);
            }
        }

        for (var cities : divisorToCity.values()) {
            for (var i = 1; i < cities.size(); ++i) {
                dsu.union(cities.get(i - 1), cities.get(i));
            }
        }

        for (var i = 0; i < queries.length; ++i) {
            var p1 = dsu.find(queries[i][0] - 1);
            var p2 = dsu.find(queries[i][1] - 1);
            res.add(p1 == p2);
        }

        return res;
    }
    
    private static ArrayList<Integer> getDivisors(int num, int threshold) {
        var res = new ArrayList<Integer>();
        
        for (var i = 1; i <= (int)Math.sqrt(num); ++i) {
            if (num % i == 0) {
                if (i > threshold) {
                    res.add(i);
                }
                
                if (num / i > threshold) {
                    res.add(num / i);
                }
            }
        }
        
        return res;
    }
    
    private static class DisjointSetUnion
    {
        private final int[] parent;
        private final int[] rank;

        public DisjointSetUnion(int size)
        {
            parent = new int[size];
            rank = new int[size];

            for (var i = 0; i < parent.length; ++i)
                parent[i] = i;
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