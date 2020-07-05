import java.util.Queue;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Comparator;

public class Solution {
    public static int solution(int src, int dest) {
        PriorityQueue<Move> q = new PriorityQueue<Move>(64, (new MoveComparator()));
        HashMap<Integer, Integer> visited = new HashMap<Integer, Integer>();
        
        q.offer((new Move(src)));
        visited.put(src, 0);
        
        while (!q.isEmpty()) {
            Move move = q.poll();
            if (move.getCell() == dest) continue;
            
            for (int[] dir : Dirs) {
                int row = move.getRow() + dir[0];
                int col = move.getCol() + dir[1];

                if (row < 0 || row > 7 || col < 0 || col > 7) continue;
                
                int cell = Move.getCell(row, col);
                int cnt = move.getCount() + 1;
                
                int currCnt = visited.getOrDefault(cell, Integer.MAX_VALUE);
                    
                if (cnt < currCnt) {
                    visited.put(cell, cnt);
                    q.offer((new Move(row, col, cnt)));
                }
            }
        }
        
        return visited.get(dest);
    }
    
    private static final int[][] Dirs = {
        { -2, 1 },
        { -1, 2 },
        { 1, 2 },
        { 2, 1 },
        { 2, -1 },
        { 1, -2 },
        { -1, -2 },
        { -2, -1 }
    };
}

class Move {
    private int row; 
    private int col; 
    private int count; 
    
    public Move(int cell) { 
        this.row = cell / 8; 
        this.col = cell % 8;
        this.count = 0; 
    } 
    
    public Move(int row, int col, int count) { 
        this.row = row; 
        this.col = col;
        this.count = count; 
    } 
    
    public int getRow() { 
        return this.row; 
    } 
    
    public int getCol() { 
        return this.col; 
    } 
    
    public int getCell() { 
        return Move.getCell(row, col);
    } 
      
    public int getCount() { 
        return count; 
    } 
    
    public static int getCell(int row, int col) {
        return row * 8 + col; 
    }
}

class MoveComparator implements Comparator<Move> { 
    public int compare(Move m1, Move m2) { 
        return m1.getCount() - m2.getCount();
    }
} 