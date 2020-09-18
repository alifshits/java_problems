class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;
        
        var p = 0;
        var buy = prices[0];
        
        for (var i = 1; i < prices.length; ++i) {
            if (prices[i] > buy) {
                p = Math.max(p, prices[i] - buy);
            } 
            else {
                buy = Math.min(buy, prices[i]);
            }
        }
        
        return p;
    }
}