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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        var map = new HashMap<Integer, List<Integer>>();
        
        Traverse(root, 0, map);
        
        return map.values().stream().collect(Collectors.toList());
    }
    
    private static void Traverse(TreeNode root, int depth, HashMap<Integer, List<Integer>> map) {
        if (root == null) return;
        
        var list = map.computeIfAbsent(depth, k -> new ArrayList<Integer>());
        if ((depth & 1) == 0) {
            list.add(root.val);
        } else {
            list.add(0, root.val);
        }
            
        Traverse(root.left, depth + 1, map);
        Traverse(root.right, depth + 1, map);
    }
}