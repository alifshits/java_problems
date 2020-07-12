class Solution {
    public double getMinDistSum(int[][] positions) {
        double left = 100, top = 0, right = 0, bottom = 100;
        for (var p : positions) {
            left = Math.min(left, p[0]);
            top = Math.max(top, p[1]);
            right = Math.max(right, p[0]);
            bottom = Math.min(bottom, p[1]);
        }
        
        double result = Double.MAX_VALUE, resX = 0, resY = 0;
        
        for (double delta = 10; delta >= 0.00001; delta /= 10) {
            for (double x = left; x <= right; x += delta) {
                for (double y = bottom; y <= top; y += delta) {
                    double sum = 0.0;
                    
                    for (var p : positions) {
                        sum += Math.sqrt((x - p[0]) * (x - p[0]) + (y - p[1]) * (y - p[1]));
                    }
                    
                    if (sum < result) {
                        result = sum;
                        resX = x;
                        resY = y;
                    }
                }
            }
            
            left = resX - delta;
            bottom = resY - delta;
            right = resX + delta;
            top = resY + delta;
        }
        
        return result == Double.MAX_VALUE ? 0 : result;
    }
}