public class Solution {
    public int compareVersion(String version1, String version2) {
        var parts1 = version1.split("\\.");
        var parts2 = version2.split("\\.");
        var i = 0;
        
        for (; i < Math.min(parts1.length, parts2.length); ++i) {
            if (i == parts1.length) return -1;
            if (i == parts2.length) return 1;
            
            var num1 = Integer.parseInt(parts1[i]);
            var num2 = Integer.parseInt(parts2[i]);
            
            if (num1 > num2) return 1;
            if (num1 < num2) return -1;
        }
        
        for (; i < parts1.length; ++i) {
            var num1 = Integer.parseInt(parts1[i]);
            if (num1 != 0) return 1;
        }
        
        for (; i < parts2.length; ++i) {
            var num2 = Integer.parseInt(parts2[i]);
            if (num2 != 0) return -1;
        }
        
        return 0;
    }
}