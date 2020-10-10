class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points.length <= 1) {
            return points.length;
        }
        
        Arrays.sort(points, (p1, p2) -> Integer.compare(p1[1], p2[1]));
        
        var cnt = 1;
        var current = points[0];     
        
        for (var i = 1; i < points.length; ++i) {
            if (Integer.compare(points[i][0], current[1]) > 0) {
                current = points[i];
                ++cnt;
            }
            else {
                current[0] = Math.max(current[0], points[i][0]);
                current[1] = Math.min(current[1], points[i][1]);
            }
        }
        
        return cnt;
    }
}