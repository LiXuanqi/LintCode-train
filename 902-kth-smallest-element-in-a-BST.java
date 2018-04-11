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
     * @param k: the given k
     * @return: the kth smallest element in BST
     */
    private int result = -1;
    private int time;
    public int kthSmallest(TreeNode root, int k) {
        time = k;
        traverse(root);
        return result;
    }
    
    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        traverse(root.left);
        time--;
        if (time == 0) {
            result = root.val;
        }

        traverse(root.right);
    }
}

// Follow up:
// if the structure of the BST changes frequently, how to improve?
// counter
// the same idea of quick select.