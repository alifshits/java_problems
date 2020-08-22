class Solution {
    public int minOperations(int n) {        
        var first = n - 1;
        var last = n % 2 == 0 ? 1 : 0;
        var total = (n + 1) / 2; 
        
        return (first + last) / 2 * total;
    }
}