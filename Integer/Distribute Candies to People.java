class Solution {
    public int[] distributeCandies(int candies, int num_people) {
        var res = new int[num_people];
        var n = (int)(-0.5 + 0.5 * Math.sqrt(8L * candies));
        var fullLoops = n / num_people;
        var remainingPeople = n % num_people;
        var remaining = fullLoops > 0 ? candies - ((n - remainingPeople) + 1) * (n - remainingPeople) / 2 : candies;
        var start = n - remainingPeople;

        for (var i = 0; i < num_people; ++i) {
            if (fullLoops > 0) {
                var a1 = i + 1;
                var aN = i + 1 + num_people * (fullLoops - 1);

                res[i] = (a1 + aN) * fullLoops / 2;
            }

            if (remaining > 0) {
                var tmp = Math.min(start + i + 1, remaining);
                res[i] += tmp;
                remaining -= tmp;
            }
        }

        return res;
    }
}