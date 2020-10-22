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
    private int depth;
    
    public int minDepth(TreeNode root) {
        depth = Integer.MAX_VALUE;
        
        minDepth(root, 1);
        
        return depth == Integer.MAX_VALUE ? 0 : depth;
    }
    
    private void minDepth(TreeNode root, int currentDepth) {
        if (root == null) {
            return;
        }
        
        if (root.left == null && root.right == null) {
            depth = Math.min(depth, currentDepth);
            return;
        }
        
        minDepth(root.left, currentDepth + 1);
        minDepth(root.right, currentDepth + 1);
    }
}