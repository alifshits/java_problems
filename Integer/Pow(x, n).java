public class Solution {
    public double myPow(double x, int n) {
        return n > 0 ? myPowInternal(x, n) : 1.0 / myPowInternal(x, -n);
    }
    
    private static double myPowInternal(double x, int n) {
        if (x == 1.0 || n == 0) return 1.0;

        if (n == 1) return x;
        if (n == 2) return x * x;
        
        var pow = myPowInternal(x, n / 2);
        return pow * pow * (n % 2 == 0 ? 1 : x);
    }
}