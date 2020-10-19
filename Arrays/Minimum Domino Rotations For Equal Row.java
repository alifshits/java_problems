class Solution {
    public int minDominoRotations(int[] A, int[] B) {
        var a = A[0];
        var b = B[0];
        
        var cnt = -1;
        var res1 = getCount(A, B, a);
        var res2 = getCount(A, B, b);
        
        var cnt1 = res1 != null ? res1.getKey() : -1;
        var cnt2 = res1 != null ? A.length - res1.getKey() - res1.getValue() : -1;
        if (res1 != null) {
            cnt = Math.min(cnt1, cnt2);
        }
        
        var cnt3 = res2 != null ? res2.getKey() : -1;
        var cnt4 = res2 != null ? A.length - res2.getKey() - res2.getValue() : -1;
        if (res2 != null) {
            cnt = cnt != -1 ? Math.min(cnt, Math.min(cnt3, cnt4)) : Math.min(cnt3, cnt4);
        }
        
        return cnt;
    }
    
    private static Pair<Integer, Integer> getCount(int[] A, int[] B, int target) {
        var cnt = 0;
        var dups = 0;
        
        for (var i = 0; i < A.length; ++i) {
            if (A[i] == target) {
                if (B[i] == target) {
                    ++dups;
                }
                continue;
            }
            
            if (B[i] == target) {
                ++cnt;
                continue;
            }
            
            return null;
        }
        
        return new Pair<>(cnt, dups);
    }
}