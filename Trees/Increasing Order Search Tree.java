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
    public TreeNode increasingBST(TreeNode root) {
        var lst = new ArrayList<TreeNode>();
        walk(root, lst);
        
        TreeNode res = null, prev = null;
        
        for (var node : lst) {
            node.left = node.right = null;
            
            if (prev == null) {
                res = prev = node;
            }
            else {
                prev.right = node;
                prev = prev.right;
            }
        }
        
        return res;
    }
    
    private static void walk(TreeNode root, ArrayList<TreeNode> lst) {
        if (root == null) {
            return;
        }
        
        walk(root.left, lst);
        
        lst.add(root);
        
        walk(root.right, lst);
    }
}