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
    private int width;
    
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        
        var levels = new HashMap<Integer, Integer>();
        
        width = 1;
        
        walk(root, levels, 0, 0);
        
        return width;
    }
    
    private void walk(TreeNode root, HashMap<Integer, Integer> levels, int depth, int idx) {
        if (root == null) return;
        
        if (levels.get(depth) == null)
            levels.put(depth, idx);
        else {
            width = Math.max(width, idx - levels.get(depth) + 1);
        }
        
        walk(root.left, levels, depth + 1, idx * 2);
        walk(root.right, levels, depth + 1, idx * 2 + 1);
    }
}