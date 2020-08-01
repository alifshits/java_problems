public class Solution {
    public boolean detectCapitalUse(String word) {
        var allLower = true;
        var allCapital = true;
        
        for (var i = 1; i < word.length(); ++i) {
            var c = word.charAt(i);
            if (c >= 65 && c <= 90) {
                allLower = false;
            } 
            else {
                allCapital = false;
            }
        }
        
        var f = word.charAt(0);
        if (f >= 65 && f <= 90) {
            return allLower || allCapital;
        }
        else {
            return allLower;
        }
    }
}