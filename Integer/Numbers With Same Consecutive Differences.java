class Solution {
    private static final int[] digits = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
    private ArrayList<Integer> result;
    
    public int[] numsSameConsecDiff(int N, int K) {
        result = new ArrayList<>();

        for (var d : digits) {
            numsSameConsecDiff(d, 1, N, K);
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    private void numsSameConsecDiff(int d, int currLen, int targetLen, int diff) {
        if (currLen == targetLen) {
            result.add(d);
            return;
        }

        if (d == 0 && currLen == 1)
            return;

        var lastD = d % 10;
        if (diff != 0) {
            if (lastD + diff < 10)
                numsSameConsecDiff(d * 10 + lastD + diff, currLen + 1, targetLen, diff);

            if (lastD - diff >= 0)
                numsSameConsecDiff(d * 10 + lastD - diff, currLen + 1, targetLen, diff);
        }
        else {
            numsSameConsecDiff(d * 10 + lastD, currLen + 1, targetLen, diff);
        }
    }
}