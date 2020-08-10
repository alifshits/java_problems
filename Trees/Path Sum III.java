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
    private int cnt;
    private int sum;
    
    public int pathSum(TreeNode root, int sum) {
        this.cnt = 0;
        this.sum = sum;
        
        traverse(root, new ArrayList<Integer>());
        
        return this.cnt;
    }
    
    private void traverse(TreeNode root, ArrayList<Integer> vals) {
        if (root == null) return;
        
        vals.add(root.val);
        
        var s = 0;
        
        for (var i = vals.size() - 1; i >= 0; --i) {
            s += vals.get(i);
            if (s == this.sum) ++this.cnt;
        }
        
        traverse(root.left, vals);
        traverse(root.right, vals);
        
        vals.remove(vals.size() - 1);
    }
}