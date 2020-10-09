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
    public boolean isEvenOddTree(TreeNode root) {
        var map = new HashMap<Integer, Integer>();
        
        if (!traverse(root, 0, map)) {
            return false;
        }       
              
        return true;
    }
    
    private static boolean traverse(TreeNode root, int level, HashMap<Integer, Integer> map) {
        if (root == null) {
            return true;
        }
        
        if (!traverse(root.left, level + 1, map)) {
            return false;
        }
        
        if (level % 2 == 0 && root.val % 2 != 0 || level % 2 != 0 && root.val % 2 == 0) {    
            var last = map.get(level);
            if (last != null) {
                if (level % 2 == 0 && last >= root.val || level % 2 != 0 && last <= root.val) {
                    return false;
                }
            }
            
            map.put(level, root.val);
        }
        else {
            return false;
        }
        
        if (!traverse(root.right, level + 1, map)) {
            return false;
        }
        
        return true;
    }
}