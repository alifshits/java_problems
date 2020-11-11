class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        var points = new int[][] { p1, p2, p3, p4 };
        var order = new int[] { -1, -1, -1, -1 };
        var used = new boolean[4];
        return check(points, 0, order, used);
    }
    
    private static boolean check(int[][] points, int point, int[] order, boolean[] used) {
        if (point == points.length) {
            return isValidSquare(points, order);
        }
        
        for (var i = 0; i < points.length; ++i) {
            if (used[i]) {
                continue;
            }
            
            order[point] = i;
            used[i] = true;
            if (check(points, point + 1, order, used)) {
                return true;
            }
            order[point] = -1;
            used[i] = false;
        }
        
        return false;
    }  
    
    private static boolean isValidSquare(int[][] points, int[] order) {
        var side1 = getLength(points[order[0]], points[order[1]]);
        if (side1 == 0) {
            return false;
        }
        
        var side2 = getLength(points[order[1]], points[order[2]]);
        if (side1 != side2) {
            return false;
        }
        
        var side3 = getLength(points[order[2]], points[order[3]]);
        if (side2 != side3) {
            return false;
        }
        
        var side4 = getLength(points[order[3]], points[order[0]]);
        if (side3 != side4) {
            return false;
        }
        
        return checkAngle(points[order[1]], points[order[0]], points[order[2]]);
    }
    
    private static int getLength(int[] p1, int[] p2) {
        return (p2[0] - p1[0]) * (p2[0] - p1[0]) + (p2[1] - p1[1]) * (p2[1] - p1[1]);
    }
                                            
    private static boolean checkAngle(int[] p1, int[] p2, int[] p3) {
        var ux = p2[0] - p1[0];  
        var uy = p2[1] - p1[1];
        var vx = p3[0] - p1[0];  
        var vy = p3[1] - p1[1];
        return ux*vx + uy*vy == 0;
    }
}