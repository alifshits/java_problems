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
    public void recoverTree(TreeNode root) {
        var arr = new ArrayList<TreeNode>();
        traverse(root, arr);
        
        TreeNode first = null, second = null;
        
        for (var i = 0; i < arr.size() - 1; ++i) {
            if (arr.get(i).val > arr.get(i + 1).val) {
                first = arr.get(i);
                break;
            }
        }
        
        for (var i = arr.size() - 1; i > 0; --i) {
            if (arr.get(i).val < arr.get(i - 1).val) {
                second = arr.get(i);
                break;
            }
        }
        
        var tmp = second.val;
        second.val = first.val;
        first.val = tmp;
    }
    
    private static void traverse(TreeNode root, ArrayList<TreeNode> arr) {
        if (root == null) {
            return;
        }
        
        traverse(root.left, arr);
        arr.add(root);
        traverse(root.right, arr);
    }
}