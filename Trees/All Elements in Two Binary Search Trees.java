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
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        var list1 = new ArrayList<Integer>();
        var list2 = new ArrayList<Integer>();
        
        Fill(root1, list1);
        Fill(root2, list2);
        
        var res = new ArrayList<Integer>(list1.size() + list2.size()); 
        var i = 0;
        var j = 0;
        
        while (i < list1.size() && j < list2.size()) {
            var n1 = list1.get(i);
            var n2 = list2.get(j);
            if (n1 <= n2) {
                res.add(n1);
                ++i;
            }
            else {
                res.add(n2);
                ++j;
            }
        }
        
        for (; i < list1.size(); ++i) {
            res.add(list1.get(i));
        }
        
        for (; j < list2.size(); ++j) {
            res.add(list2.get(j));
        }
        
        return res;
    }
    
    private static void Fill(TreeNode root, ArrayList<Integer> list) {
        if (root == null) return;
        
        Fill(root.left, list);
        
        list.add(root.val);
        
        Fill(root.right, list);
    }
}