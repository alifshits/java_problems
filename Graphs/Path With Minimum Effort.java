class Solution {
    public int minimumEffortPath(int[][] heights) {
        int result = Integer.MAX_VALUE;
        Queue<State> q = new PriorityQueue<>(Comparator.comparingInt(s -> s.effort));
        HashMap<State, Integer> visited = new HashMap<>();

        var firstState = new State(0, 0, 0);
        q.offer(firstState);
        visited.put(firstState, 0);

        while (q.size() > 0) {
            var current = q.poll();
            if (current.r == heights.length - 1 && current.c == heights[current.r].length - 1) {
                result = Math.min(result, current.effort);
                continue;
            }

            for (var d : dirs) {
                var r = current.r + d[0];
                var c = current.c + d[1];

                if (r < 0 || r == heights.length || c < 0 || c == heights[r].length) {
                    continue;
                }

                var newState = new State(r, c, Math.max(current.effort, Math.abs(heights[current.r][current.c] - heights[r][c])));

                var cachedEffort = visited.get(newState);
                if (cachedEffort == null || cachedEffort > newState.effort) {
                    visited.put(newState, newState.effort);
                    q.offer(newState);
                }
            }
        }

        return result;
    }
    
    private static final int[][] dirs = {
        { 0, 1 },
        { 1, 0 },
        { 0, -1 },
        { -1, 0 }
    };
    
    private static final class State {
        public final int r;
        public final int c;
        public final int effort;
        private final int hash;
        
        public State(int r, int c, int effort) {
            this.r = r;
            this.c = c;
            this.effort = effort;
            this.hash = Objects.hash(r, c);
        }
        
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            State state = (State) o;
            return r == state.r && c == state.c;
        }

        @Override
        public int hashCode() {
            return hash;
        }
    }
}