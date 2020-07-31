class Solution {
    private int count;
    private int distance;

    public int countPairs(TreeNode root, int distance) {
        this.count = 0;
        this.distance = distance;

        getDistances(root, 0);

        return count;
    }

    private TreeMap<Integer, Integer> getDistances(TreeNode root, int depth) {
        if (root == null) return null;

        var left = getDistances(root.left, depth + 1);
        var right = getDistances(root.right, depth + 1);

        if (left == null && right == null) {
            var map = new TreeMap<Integer, Integer>();
            map.put(depth, 1);
            return map;
        }

        if (left != null && right != null) {
            count += count(left, right, depth);

            var merged = new TreeMap<Integer, Integer>();

            for (var entry : left.entrySet()) {
                if (entry.getKey() - depth < distance) {
                    merged.put(entry.getKey(), entry.getValue());
                }
            }

            for (var entry : right.entrySet()) {
                if (entry.getKey() - depth < distance) {
                    var existing = merged.get(entry.getKey());
                    if (existing != null) {
                        merged.replace(entry.getKey(), existing + entry.getValue());
                    } else {
                        merged.put(entry.getKey(), entry.getValue());
                    }
                }
            }

            return merged;
        }

        return left != null ? left : right;
    }

    private int count(TreeMap<Integer, Integer> left, TreeMap<Integer, Integer> right, int depthSoFar) {
        var count = 0;

        for (var entry : left.entrySet()) {
            var leftDepth = entry.getKey() - depthSoFar;
            var max = distance - leftDepth;

            var headMap = right.headMap(depthSoFar + max, true);
            for (var x : headMap.values()) {
                count += x * entry.getValue();
            }
        }

        return count;
    }
}