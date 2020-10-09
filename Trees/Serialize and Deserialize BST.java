/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        var sb = new StringBuilder();
        serialize(root, sb);
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
    
    private static void serialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("#,");
            return;
        }
        
        sb.append(root.val);
        sb.append(",");
        
        serialize(root.left, sb);
        serialize(root.right, sb);
    }
    
    private int i;

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        var parts = data.split(",");
        i = 0;
        return deserialize(parts);
    }
    
    private TreeNode deserialize(String[] parts) {
        if (i == parts.length) {
            return null;
        }
        
        if (parts[i].equals("#")) {
            ++i;
            return null;
        }
        
        var node = new TreeNode(Integer.parseInt(parts[i]));
        ++i;
        node.left = deserialize(parts);
        node.right = deserialize(parts);
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;