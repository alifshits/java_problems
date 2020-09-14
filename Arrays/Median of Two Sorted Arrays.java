class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        var first = nums1.length >= nums2.length ? nums1 : nums2;
        var second = nums1.length >= nums2.length ? nums2 : nums1;

        var lo = 0;
        var hi = second.length;
        var half = (first.length + second.length + 1) / 2;

        while (lo <= hi) {
            var m2 = lo + (hi - lo) / 2;
            var m1 = half - m2;

            var l1 = m1 > 0 ? first[m1 - 1] : Integer.MIN_VALUE;
            var r1 = m1 < first.length ? first[m1] : Integer.MAX_VALUE;

            var l2 = m2 > 0 ? second[m2 - 1] : Integer.MIN_VALUE;
            var r2 = m2 < second.length ? second[m2] : Integer.MAX_VALUE;
            
            var max = Math.max(l1, l2);
            var min = Math.min(r1, r2);

            if (max <= min) {
                if ((first.length + second.length) % 2 == 0) {
                    return (max + min) / 2.0;
                }
                else {
                    return max;
                }
            }

            if (l1 >= r2 && l2 <= r1) {
                lo = m2 + 1;
            }
            else {
                hi = m2 - 1;
            }
        }

        return 0;
    }
}