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
    private int tiltSum;
    
    public int findTilt(TreeNode root) {
        tiltSum = 0;
        
        sum(root);
        
        return tiltSum;        
    }
    
    private int sum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        var left = sum(root.left);
        var right = sum(root.right);
        
        tiltSum += Math.abs(left - right);
        
        return left + right + root.val;
    }
}