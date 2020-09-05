class Solution {
    public String largestTimeFromDigits(int[] A) {
        var permutations = new ArrayList<int[]>(16);
        int maxH = -1, maxM = -1, max = -1;
        
        generate(A, 0, new int[4], permutations);
        
        for (var p : permutations) {
            var h = p[0] * 10 + p[1];
            var m = p[2] * 10 + p[3];
            
            if (h > 23 || m > 59) {
                continue;
            }
            
            var maxTmp = h * 60 + m;
            if (maxTmp > max) {
                max = maxTmp;
                maxH = h;
                maxM = m;
            }
        }
        
        if (max == -1) return "";
        
        var sb = new StringBuilder();
        
        if (maxH < 10) sb.append("0");
        sb.append(maxH);
        
        sb.append(":");
        
        if (maxM < 10) sb.append("0");
        sb.append(maxM);
        
        return sb.toString();
    }
    
    private static void generate(int[] A, int idx, int[] current, ArrayList<int[]> permutations) {
        if (idx == A.length) {
            permutations.add(current.clone());
            return;
        }
        
        for (var i = 0; i < A.length; ++i) {
            if (A[i] == -1) continue;
            
            var tmp = A[i];
            A[i] = -1;
            
            current[idx] = tmp;
            
            generate(A, idx + 1, current, permutations);
            
            current[idx] = 0;
            
            A[i] = tmp;
        }
    }
}