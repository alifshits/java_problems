class Solution {
    public String findLexSmallestString(String s, int a, int b) {
        var q = new LinkedList<String>();
        var visited = new HashSet<String>();
        var min = s;

        q.offer(s);
        visited.add(s);

        while (q.size() > 0) {
            var current = q.pop();
            if (current.compareTo(min) < 0) {
                min = current;
            }

            var rotated = rotate(current, b);
            if (visited.add(rotated)) {
                q.offer(rotated);
            }

            var added = add(current, a);
            if (visited.add(added)) {
                q.offer(added);
            }
        }

        return min;
    }

    private static String add(String original, int a) {
        var sb = new StringBuilder(original);
        var start = original.length() % 2 == 0 ? 1 : 0;
        for (var i = start; i < original.length(); i += 2) {
            var newChar = ((original.charAt(i) - '0') + a) % 10;
            sb.setCharAt(i, (char) (newChar + '0'));
        }

        return sb.toString();
    }

    private static String rotate(String original, int b) {
        var sb = new StringBuilder(original);

        for (var i = 0; i < original.length(); ++i) {
            sb.setCharAt((i + b) % original.length(), original.charAt(i));
        }

        return sb.toString();
    }
}