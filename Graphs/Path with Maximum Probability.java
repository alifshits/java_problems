class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        var pathMap = GetPathMap(edges, succProb);
        var pq = new PriorityQueue<Vertex>((x, y) -> Double.compare(y.getProb(), x.getProb()));
        var visited = new HashMap<Integer, Double>();

        pq.offer(new Vertex(start, 1.0));
        visited.put(start, 1.0);

        while (pq.size() > 0) {
            var v = pq.poll();
            if (v.idx == end) {
                continue;
            }

            var neighbors = pathMap.get(v.getIdx());
            if (neighbors != null) {
                for (var neighbor : neighbors.entrySet()) {
                    var newProb = v.getProb() * neighbor.getValue();
                    var currentProb = visited.get(neighbor.getKey());
                    if (currentProb == null || currentProb < newProb) {
                        pq.offer(new Vertex(neighbor.getKey(), newProb));
                        visited.put(neighbor.getKey(), newProb);
                    }
                }
            }
        }

        var result = visited.get(end);
        return result != null ? result : 0.0;
    }

    private static HashMap<Integer, HashMap<Integer, Double>> GetPathMap(int[][] edges, double[] succProb) {
        var map = new HashMap<Integer, HashMap<Integer, Double>>();

        for (var i = 0; i < edges.length; ++i) {
            var edge = edges[i];

            if (map.get(edge[0]) == null) {
                map.put(edge[0], new HashMap<Integer, Double>());
            }

            if (map.get(edge[1]) == null) {
                map.put(edge[1], new HashMap<Integer, Double>());
            }

            map.get(edge[0]).put(edge[1], succProb[i]);
            map.get(edge[1]).put(edge[0], succProb[i]);
        }

        return map;
    }

    class Vertex {
        private int idx;
        private double prob;

        public Vertex(int idx, double prob) {
            this.idx = idx;
            this.prob = prob;
        }

        public int getIdx() {
            return idx;
        }

        public double getProb() {
            return prob;
        }
    }
}