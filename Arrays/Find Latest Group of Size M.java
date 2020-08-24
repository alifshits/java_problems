class Solution {
    public int findLatestStep(int[] arr, int m) {
        if (m == arr.length) return arr.length;

        var tree = new TreeSet<Integer>();
        tree.add(0);
        tree.add(arr.length + 1);
        
        var step = -1;

        for (var i = arr.length - 1; i >= 0; --i) {
            var left = tree.floor(arr[i]);
            var right = tree.ceiling(arr[i]);

            if (arr[i] - left - 1 == m || right - arr[i] - 1 == m) {
                step = i;
                break;
            }

            tree.add(arr[i]);
        }

        return step;
    }
}