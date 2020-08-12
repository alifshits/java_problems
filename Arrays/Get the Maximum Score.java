class Solution {    
    public int maxSum(int[] nums1, int[] nums2) {
        int m = 1000000000 + 7, prev1 = -1, prev2 = -1;
        long sum = 0;

        HashMap<Integer, Integer> map2 = new HashMap<>(nums2.length);
        long[] sums1 = new long[nums1.length], sums2 = new long[nums2.length];

        for (var k = 0; k < nums1.length; ++k) {
            sums1[k] = nums1[k] + (k - 1 >= 0 ? sums1[k - 1] : 0);
        }

        for (var k = 0; k < nums2.length; ++k) {
            map2.put(nums2[k], k);
            sums2[k] = nums2[k] + (k - 1 >= 0 ? sums2[k - 1] : 0);
        }

        for (var i = 0; i < nums1.length; ++i) {
            var idx2 = map2.get(nums1[i]);
            if (idx2 == null) continue;

            var sum1SoFar = sums1[i] - (prev1 >= 0 ? sums1[prev1] : 0);
            var sum2SoFar = sums2[idx2] - (prev2 >= 0 ? sums2[prev2] : 0);

            prev1 = i;
            prev2 = idx2;

            sum += Math.max(sum1SoFar, sum2SoFar);
        }

        var sum1SoFar = sums1[nums1.length - 1] - (prev1 >= 0 ? sums1[prev1] : 0);
        var sum2SoFar = sums2[nums2.length - 1] - (prev2 >= 0 ? sums2[prev2] : 0);

        sum += Math.max(sum1SoFar, sum2SoFar);

        return (int)(sum % m);
    }
}