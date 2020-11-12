class Solution {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();

        HashMap<Integer, Integer> counts = new HashMap<>();
        for (int num : nums) {
            var cnt = counts.getOrDefault(num, 0);
            counts.put(num, cnt + 1);
        }

        permuteUnique(new LinkedList<Integer>(), nums.length, counts, results);
        return results;
    }

    private static void permuteUnique(
            LinkedList<Integer> current,
            Integer size,
            HashMap<Integer, Integer> counts,
            List<List<Integer>> results) {

        if (current.size() == size) {
            results.add(new ArrayList<Integer>(current));
            return;
        }

        for (var entry : counts.entrySet()) {
            var num = entry.getKey();
            var count = entry.getValue();
            if (count == 0) {
                continue;
            }
            
            current.addLast(num);
            counts.put(num, count - 1);
            
            permuteUnique(current, size, counts, results);

            current.removeLast();
            counts.put(num, count);
        }
    }
}