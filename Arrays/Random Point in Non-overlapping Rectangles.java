class Solution {    
    private final Rect[] rects;
    private final int totalSquare;
    private final Random rand = new Random();

    public Solution(int[][] rectsArr) {
        rects = new Rect[rectsArr.length];
        
        var square = 0;
        
        for (var i = 0; i < rectsArr.length; ++i) {
            var rect = rectsArr[i];
            
            square += Math.abs(rect[2] - rect[0] + 1) * Math.abs(rect[3] - rect[1] + 1);
            rects[i] = new Rect(square, rect);
        }
        
        totalSquare = square;
    }
    
    public int[] pick() {
        var rectSquare = rand.nextInt(totalSquare + 1);
        var rectIdx = findRect(rectSquare);
        
        var x = rand.nextInt(rects[rectIdx].width + 1);
        var y = rand.nextInt(rects[rectIdx].height + 1);
        
        return new int[] { x + rects[rectIdx].rect[0], y + rects[rectIdx].rect[1] };
    }
    
    private int findRect(int square) {
        var lo = 0;
        var hi = rects.length - 1;
        
        while (lo <= hi) {
            var m = lo + (hi - lo) / 2;
            
            if (rects[m].square == square) {
                return m;
            }
            
            if (rects[m].square < square) {
                lo = m + 1;
            }
            else {
                hi = m - 1;
            } 
        }
        
        return lo;
    }
    
    private static final class Rect {
        public final int square;
        public final int[] rect;
        public final int width;
        public final int height;
        
        public Rect(int square, int[] rect) {
            this.square = square;
            this.rect = rect;
            this.width = Math.abs(rect[2] - rect[0]);
            this.height = Math.abs(rect[3] - rect[1]);
        }
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(rects);
 * int[] param_1 = obj.pick();
 */