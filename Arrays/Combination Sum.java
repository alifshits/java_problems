class Solution {
    private ArrayList<List<Integer>> result;
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<List<Integer>>();
        combinationSum(candidates, 0, target, 0, new ArrayList<Integer>());
        return result;
    }
    
    private void combinationSum(
        int[] candidates, 
        int i, 
        int target, 
        int sumSoFar, 
        ArrayList<Integer> combination) {
        
        if (sumSoFar == target) {
            result.add((List<Integer>)combination.clone());
            return;
        }
        
        if (sumSoFar > target) {
            return;
        }
        
        for (; i < candidates.length; ++i) {
            combination.add(candidates[i]);
            combinationSum(candidates, i, target, sumSoFar + candidates[i], combination);
            combination.remove(combination.size() - 1);
        }
    }
}