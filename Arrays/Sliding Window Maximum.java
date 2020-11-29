class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k >= nums.length) {
            var max = Arrays.stream(nums).max().getAsInt();
            return new int[] { max };
        }
        
        var pq = new PriorityQueue<Pair<Integer, Integer>>((x, y) -> Integer.compare(y.getKey(), x.getKey()));
        var start = 0;
        var j = 0;
        var res = new int[nums.length - k + 1];
        
        for (var i = 0; i < nums.length; ++i) {
            pq.offer(new Pair<>(nums[i], i));
            
            if (i - start + 1 == k) {
                while (pq.peek().getValue() < start) {
                    pq.poll();
                }
                
                res[j++] = pq.peek().getKey();
                
                ++start;
            }
        }
        
        return res;
    }
}