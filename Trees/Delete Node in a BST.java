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
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        
        if (root.val == key) {
            var left = deleteNode(root.left, key);
            var right = deleteNode(root.right, key);
            if (left == null && right == null) return null;
            if (right == null) return left;
            if (left == null) return right;
            
            var mostLeft = getMostLeft(right);
            mostLeft.left = left;
            return right;
        }
        
        root.left = deleteNode(root.left, key);
        root.right = deleteNode(root.right, key);
        
        return root;
    }
    
    private static TreeNode getMostLeft(TreeNode root) {
        if (root.left == null) return root;
        return getMostLeft(root.left);
    }
}