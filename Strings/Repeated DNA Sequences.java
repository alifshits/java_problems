class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        var res = new ArrayList<String>();
        var map = new HashMap<Long, Integer>();
        long hash = 0;
        int base = 26;
        int len = 10;

        for (var i = 0; i < s.length(); ++i) {
            if (len > 0) {
                var current = s.charAt(i) - 'A';
                hash += current * Math.pow(base, len - 1);
                --len;
            }
            else {
                var first = s.charAt(i - 10) - 'A';
                var current = s.charAt(i) - 'A';
                hash -= first * Math.pow(base, 9);
                hash *= base;
                hash += current;
            }

            if (len == 0) {
                var cnt = map.getOrDefault(hash, 0);
                map.put(hash, cnt + 1);

                if (cnt == 1) {
                    res.add(s.substring(i - 9, i + 1));
                }
            }
        }

        return res;
    }
}