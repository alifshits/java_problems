class Solution {
    public int maxDistToClosest(int[] seats) {
        var res = 1;
        var start = -1;
        
        for (var i = 0; i < seats.length; ++i) {
            if (seats[i] == 1) {
                if (start == -1) {
                    res = i;
                }
                else {
                    res = Math.max(res, (i - start) / 2);
                }
                
                start = i;
            }
        }
        
        if (start < seats.length - 1) {
            res = Math.max(res, seats.length - start - 1);
        }
        
        return res;
    }
}