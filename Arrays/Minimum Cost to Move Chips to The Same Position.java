class Solution {
    public int minCostToMoveChips(int[] position) {
        var odd = 0;
        var even = 0;
        
        for (var p : position) {
            if (p % 2 == 0) {
                ++even;
            }
            else {
                ++odd;
            }
        }
        
        return Math.min(odd, even);
    }
}