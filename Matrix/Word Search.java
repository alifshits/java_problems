class Solution {
    public boolean exist(char[][] board, String word) {
        for (var i = 0; i < board.length; ++i) {
            for (var j = 0; j < board[i].length; ++j) {
                var visited = new HashSet<State>();
                var state = new State(i, j);                   
                visited.add(state);
                
                if (exist(board, state, 0, word, visited))
                    return true;
            }
        }
        
        return false;
    }
    
    private boolean exist(char[][] board, State state, int i, String word, HashSet<State> visited) {        
        if (word.charAt(i) != board[state.r][state.c]) return false;
        
        if (i == word.length() - 1) return true;
     
        for (var d : Dirs) {
            var newR = state.r + d[0];
            var newC = state.c + d[1];
            
            if (newR < 0 || newR == board.length || newC < 0 || newC == board[newR].length) continue;
            
            var newState = new State(newR, newC);
            if (visited.add(newState)) {
                if (exist(board, newState, i + 1, word, visited))
                    return true;
                visited.remove(newState);
            }
        }
        
        return false;
    }
    
    private static final int[][] Dirs = {
        {0, 1},
        {0, -1},
        {1, 0},
        {-1, 0}
    };
    
    class State {
        public final int r;
        public final int c;
        
        public State(int r, int c) {
            this.r = r;
            this.c = c;
        }
        
        @Override
        public boolean equals(Object object) {
            if (this == object) return true;

            var other = (State)object;
            return r == other.r && c == other.c;
        }
        
        @Override
        public int hashCode() {
            return Objects.hash(r, c);
        }
    }
}