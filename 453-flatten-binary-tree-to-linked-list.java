/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */

public class Solution {
    /**
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
    public void flatten(TreeNode root) {
        helper(root);
    }
    
    private TreeNode helper(TreeNode root) {
        if (root == null) {
            return null;
        }
        
        TreeNode leftLast = helper(root.left);
        TreeNode rightLast = helper(root.right);
        // leftLast = null
        // 1 # 2
        if (leftLast != null) {
            leftLast.right = root.right;
            root.right = root.left;
            root.left = null;    
        }

        
        if (rightLast != null) {
            return rightLast;
        }
        // leftLast != null && rightLast == null
        if (leftLast != null) {
            return leftLast;
        }
        return root;
    }
}