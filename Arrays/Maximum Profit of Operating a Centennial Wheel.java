class Solution {
    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        var maxProfit = Integer.MIN_VALUE;
        var maxRotation = -1;
        var taken = 0;
        var waiting = 0;
        var i = 0;

        while (waiting > 0 || i < customers.length) {
            if (i < customers.length) {
                waiting += customers[i];
            }

            var toBoard = Math.min(waiting, 4);

            taken += toBoard;
            waiting -= toBoard;

            var profit = taken * boardingCost - (i + 1) * runningCost;

            if (profit > maxProfit) {
                maxProfit = profit;
                maxRotation = i + 1;
            }

            ++i;
        }

        return maxProfit > 0 ? maxRotation : -1;
    }
}