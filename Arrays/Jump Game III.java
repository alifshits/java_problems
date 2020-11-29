class Solution {
    public boolean canReach(int[] arr, int start) {
        var memo = new Boolean[arr.length];
        return canReach(arr, start, memo);
    }
    
    private static boolean canReach(int[] arr, int start, Boolean[] memo) {
        if (arr[start] == 0) {
            return true;
        }
        
        if (memo[start] != null) {
            return memo[start];
        }
        
        memo[start] = false;
        
        var res1 = start - arr[start] >= 0 ? canReach(arr, start - arr[start], memo) : false;
        var res2 = !res1 && start + arr[start] < arr.length ? canReach(arr, start + arr[start], memo) : false;
        
        memo[start] = res1 || res2;
        
        return memo[start];
    }
}