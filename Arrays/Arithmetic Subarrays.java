class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        var res = new ArrayList<Boolean>(l.length);
        
        for (var i = 0; i < l.length; ++i) {
            if (l[i] == r[i]) {
                res.add(false);
                continue;
            }
            
            var sub = Arrays.copyOfRange(nums, l[i], r[i] + 1);
            Arrays.sort(sub);
            
            var seq = true;
            var diff = sub[1] - sub[0];
            for (var j = 2; j < sub.length; ++j) {
                if (sub[j] - sub[j - 1] != diff) {
                    seq = false;
                    break;
                }
            }
            
            res.add(seq);
        }
        
        return res;
    }
}