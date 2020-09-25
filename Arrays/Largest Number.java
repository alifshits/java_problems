class Solution {
    public String largestNumber(int[] nums) {
        if (nums.length == 0) {
            return "";
        }
        
        var sorted = Arrays.stream(nums)
            .boxed()
            .map(num -> String.valueOf(num))
            .sorted((x, y) -> {
                var a = x + y;
                var b = y + x;
                return b.compareTo(a);
            })
            .toArray(String[]::new);
        
        if (sorted[0].equals("0")) {
            return "0";
        }
        
        var sb = new StringBuilder();
        
        for (var item : sorted) {
            sb.append(item);
        }
        
        return sb.toString();
    }
}