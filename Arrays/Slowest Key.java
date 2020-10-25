class Solution {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        var max = Integer.MIN_VALUE; 
        var idx = -1;
        
        for (var i = 0; i < releaseTimes.length; ++i) {
            var time = i > 0 ? releaseTimes[i] - releaseTimes[i - 1] : releaseTimes[i];
            if (time > max || time == max && keysPressed.charAt(i) > keysPressed.charAt(idx)) {
                max = time;
                idx = i;
            }
        }
        
        return keysPressed.charAt(idx);
    }
}