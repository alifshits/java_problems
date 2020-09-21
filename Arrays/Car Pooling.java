class Solution {
    public boolean carPooling(int[][] trips, int capacity) {        
        var route = new int[1001];
        
        for (var trip : trips) {
            for (var d = trip[1]; d < trip[2]; ++d) {
                route[d] += trip[0];
                if (route[d] > capacity) {
                    return false;
                }
            }
        }
        
        return true;
    }
}