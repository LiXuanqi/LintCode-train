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
     * @param root: the given BST
     * @param target: the given target
     * @return: the value in the BST that is closest to the target
     */
    private double minDifference;
    private int result;
    public int closestValue(TreeNode root, double target) {
        minDifference = Double.MAX_VALUE;
        traverse(root, target);
        return result;
    }
    private void traverse(TreeNode root, double target) {
        if (root == null) {
            return;
        }
        int val = root.val;
        if (Math.abs(val - target) < minDifference) {
            minDifference = Math.abs(val - target);
            result = val;
        }
        traverse(root.left, target);
        traverse(root.right, target);
    }
}