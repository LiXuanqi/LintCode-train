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
     * @param root: the root of binary tree
     * @return: the root of the minimum subtree
     */
    private TreeNode subtree;
    private int minSum;
    public TreeNode findSubtree(TreeNode root) {
        minSum = Integer.MAX_VALUE;
        helper(root);
        return subtree;
    }
    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = root.val + helper(root.left) + helper(root.right);
        if (sum < minSum) {
            subtree = root;
            minSum = sum;
        }
        return sum;
    }
}