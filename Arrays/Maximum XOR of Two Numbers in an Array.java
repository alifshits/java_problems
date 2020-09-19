class Solution {
    public int findMaximumXOR(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        var trie = new Trie();
        
        for (var num : nums) {
            trie.add(num, 30);
        }
        
        var sum = 0;
        
        for (var num : nums) {
            var sumTmp = 0;
            var trieTmp = trie;
            
            for (var i = 30; i >= 0; --i) {
                var x = (num >> i) & 1;
                var notX = x == 1 ? 0 : 1;
                if (trieTmp.get(notX) != null) {
                    sumTmp += (1 << i);
                    trieTmp = trieTmp.get(notX);
                } 
                else {
                    trieTmp = trieTmp.get(x);
                }
            }
            
            sum = Math.max(sum, sumTmp);
        }
        
        return sum;
    }
    
    private static final class Trie {
        private final Trie[] tries = new Trie[2];
        
        public void add(int num, int shift) {   
            if (shift < 0) return;

            var x = (num >> shift) & 1;
            if (tries[x] == null) {
                tries[x] = new Trie();
            }
            
            tries[x].add(num, shift - 1);
        }
        
        public Trie get(int x) {
            return tries[x];
        }
    }
}