class Solution {
    public int maxProductPath(int[][] grid) {
        var m = 1000000000 + 7;
        var q = new LinkedList<Point>();
        long res = -1;
        var visitedP = new HashMap<Point, Long>();
        var visitedN = new HashMap<Point, Long>();

        var start = new Point(0, 0, grid[0][0]);

        q.offer(start);

        if (start.p >= 0) {
            visitedP.put(start, start.p);
        }
        else {
            visitedN.put(start, start.p);
        }

        while (q.size() > 0) {
            var p = q.poll();
            if (p.r == grid.length -1 && p.c == grid[p.r].length - 1) {
                if (p.p >= 0) {
                    res = Math.max(res, p.p);
                }
                
                continue;
            }
            
            for (var dir : dirs) {
                var r = p.r + dir[0];
                var c = p.c + dir[1];
                
                if (r == grid.length || c == grid[r].length) {
                    continue;
                }
                
                var point = new Point(r, c, p.p * grid[r][c]);
                if (point.p >= 0) {
                    var tmp = visitedP.get(point);
                    if (tmp == null || tmp < point.p) {
                        visitedP.put(point, point.p);
                        q.offer(point);
                    }
                }
                else {
                    var tmp = visitedN.get(point);
                    if (tmp == null || tmp > point.p) {
                        visitedN.put(point, point.p);
                        q.offer(point);
                    }
                }
            }
        }

        return (int)(res % m);
    }
    
    private static final int[][] dirs = new int[][] { {0, 1}, {1, 0}};

    private static final class Point {
        public final int r;
        public final int c;
        public final long p;
        private final int hash;

        public Point(int r, int c, long p) {
            this.r = r;
            this.c = c;
            this.p = p;
            this.hash = Objects.hash(r, c);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            Point other = (Point) o;
            return r == other.r && c == other.c;
        }

        @Override
        public int hashCode() {
            return hash;
        }
    }
}