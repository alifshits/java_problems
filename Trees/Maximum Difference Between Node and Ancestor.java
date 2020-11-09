/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int res;
    
    public int maxAncestorDiff(TreeNode root) {
        res = Integer.MIN_VALUE;
        
        getMaxMin(root);
        
        return res;
    }
    
    private Pair<Integer, Integer> getMaxMin(TreeNode root) {   
        if (root == null) {
            return null;
        }
        
        if (root.left == null && root.right == null) {
            return new Pair(root.val, root.val);
        }
        
        var left = getMaxMin(root.left);
        var right = getMaxMin(root.right);
        
        Integer max = null, min = null;
        
        if (left != null) {
            max = left.getKey();
            min = left.getValue();
        }
        
        if (right != null) {
            max = max == null ? right.getKey() : Math.max(max, right.getKey());            
            min = min == null ? right.getValue() : Math.min(min, right.getValue());            
        }  
        
        var tmp = Math.max(Math.abs(root.val - max), Math.abs(root.val - min));
        res = Math.max(res, tmp);
        
        return new Pair(Math.max(max, root.val), Math.min(root.val, min));
    }
}