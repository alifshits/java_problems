class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        
        var i = 0;
        var j = piles.length - 1;
        var sum = 0;
        
        while (i < j) {
            --j;
            sum += piles[j];
            --j;
            ++i;
        }       
        
        return sum;
    }
}