class Solution {
    public List<Integer> pancakeSort(int[] A) {
        var flips = new ArrayList<Integer>();

        for (var num = A.length; num >= 1; --num) {
            for (var i = 0; i < A.length; ++i) {
                if (A[i] == num) {
                    if (i + 1 != num) {
                        if (i > 0) {
                            flip(A, i);  
                            flips.add(i + 1);
                        }
                        
                        if (num - 1 > 0) {
                            flip(A, num - 1);  
                            flips.add(num);
                        }
                    }

                    break;
                }
            }
        }

        return flips;
    }

    private static void flip(int[] A, int idx) {
        for (int i = 0, j = idx; i < j; ++i, --j) {
            var tmp = A[i];
            A[i] = A[j];
            A[j] = tmp;
        }
    }
}