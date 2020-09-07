class Solution {
    public int minCost(String s, int[] cost) {
        var res = 0;
        var start = 0;
        for (var i = 1; i < s.length(); ++i) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                continue;
            }
            else {
                res += i - 1 - start > 0 ? getCost(cost, start, i - 1) : 0;                
                start = i;
            }
        }
        
        if (start < s.length() - 1) {
            res += getCost(cost, start, s.length() - 1);   
        }
        
        return res;
    }
    
    private int getCost(int[] cost, int start, int end) {
        var res = 0;
        var pq = new PriorityQueue<Integer>(end - start + 1);
        
        for (var i = start; i <= end; ++i) {
            pq.offer(cost[i]);
        }
        
        for (var i = 0; i < end - start; ++i) {
            res += pq.poll();
        }
        
        return res;
    }
}