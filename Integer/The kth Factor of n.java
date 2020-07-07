class Solution {
    public int kthFactor(int n, int k) {
        var factors = new ArrayList<Integer>();
        
        for (var i = 1; i <= (int)Math.sqrt(n); ++i) {
            if (n % i == 0) {                
                factors.add(i);
                
                var second = n / i;
                if (i != second) factors.add(second);
            }
        }
        
        Collections.sort(factors);
        
        if (k > factors.size()) return -1;
        return factors.get(k - 1);
    }
}