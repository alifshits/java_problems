class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        var res = new ArrayList<Integer>();
        var maxLength = 0;

        var tmp = high;
        while (tmp > 0)
        {
            ++maxLength;
            tmp /= 10;
        }

        for (var length = 1; length <= maxLength; ++length)
        {
            for (var i = 1; i <= 8; ++i) {
                var num = i;
                var last = i + 1;

                if (last + length > 10) {
                    break;
                }

                for (var currLen = 0; currLen < length; ++currLen) {
                    num = num * 10 + last;
                    ++last;
                }

                if (num < low) {
                    continue;
                }

                if (num > high) {
                    break;
                }

                res.add(num);
            }
        }

        return res;
    }
}