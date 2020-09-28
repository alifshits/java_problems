class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries.length == 0 || duration == 0) {
            return 0;
        }
        
        var time = 0;
        var end = 0;
        
        for (var i = 0; i < timeSeries.length; ++i) {
            if (timeSeries[i] < end) {
                time -= end - timeSeries[i];
            }
            
            time += duration;
            end = timeSeries[i] + duration;
        }
        
        return time;
    }
}