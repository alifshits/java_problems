class Solution {
    public int getLastMoment(int n, int[] left, int[] right) {
        var maxLeft = Integer.MIN_VALUE;
        var minRight = Integer.MAX_VALUE;
        
        for (var ant : left)
            maxLeft = Math.max(maxLeft, ant);
        
         for (var ant : right)
            minRight = Math.min(minRight, ant);
        
        return Math.max(n - minRight, maxLeft);
    }
}