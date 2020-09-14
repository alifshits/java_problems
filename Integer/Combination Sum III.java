class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        var results = new ArrayList<List<Integer>>();
        combinationSum3(k, n, 1, new ArrayList<Integer>(), 0, results);
        return results;
    }
    
    private static void combinationSum3(
        int k, 
        int n, 
        int i,
        ArrayList<Integer> current, 
        int sumSoFar,
        ArrayList<List<Integer>> results) {
        
        if (current.size() == k) {
            if (sumSoFar == n) {
                results.add((List<Integer>)current.clone());
            }
            
            return;
        }
        
        if (sumSoFar >= n) {
            return;
        }
        
        for (; i <= 9; ++i) {
            current.add(i);
            
            combinationSum3(k, n, i + 1, current, sumSoFar + i, results);
            
            current.remove(current.size() - 1);
        }
    }
}