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
     * @param root: The root of binary tree.
     * @return: True if this Binary tree is Balanced, or false.
     */
    class ResultType {
        int depth;
        boolean isBalance;
        public ResultType(int depth, boolean isBalance) {
            this.depth = depth;
            this.isBalance = isBalance;
        }
    }
    
    public boolean isBalanced(TreeNode root) {
        return maxDepth(root).isBalance;
    }
    
    private ResultType maxDepth(TreeNode root) {
        if (root == null) {
            return new ResultType(0, true);
        }
        
        ResultType left = maxDepth(root.left);
        ResultType right = maxDepth(root.right);
        
        if (left.isBalance == false || right.isBalance == false) {
            return new ResultType(-1, false);
        }
        
        if (Math.abs(left.depth - right.depth) > 1) {
            return new ResultType(-1, false);
        }
        
        return new ResultType(Math.max(left.depth, right.depth) + 1, true);
        
    }
}