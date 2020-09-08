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
    private int sum;
    
    public int sumRootToLeaf(TreeNode root) {
        sum = 0;
        
        sumRootToLeaf(root, 0);
        
        return sum;
    }
    
    private void sumRootToLeaf(TreeNode root, int current) {
        current <<= 1;
        current |= root.val;
        
        if (root.left == null && root.right == null) {
            sum += current;
            return;
        }
        
        if (root.left != null) {
            sumRootToLeaf(root.left, current);
        }
        
        if (root.right != null) {
            sumRootToLeaf(root.right, current);
        }
    }
}