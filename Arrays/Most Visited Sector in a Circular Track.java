class Solution {
    public List<Integer> mostVisited(int n, int[] rounds) {
        var map = new int[n];
        var max = 0;

        for (var i = 1; i < rounds.length; ++i) {
            var sector = i - 1 == 0 ? rounds[i - 1] - 1 : rounds[i - 1];
            while (true) {
                if (sector == n) {
                    sector = 0;
                }

                map[sector] += 1;
                max = Math.max(max, map[sector]);

                if (sector == rounds[i] - 1) {
                    break;
                }

                ++sector;
            }
        }

        var result = new ArrayList<Integer>();
        for (var i = 0; i < map.length; ++i) {
            if (map[i] == max) {
                result.add(i + 1);
            }
        }

        return result;
    }
}