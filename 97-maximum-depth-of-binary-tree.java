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

// Solution 1 : traverse.

public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: An integer
     */
    private int depth; 
     
    public int maxDepth(TreeNode root) {
        depth = 0;
        traverse(root, 1);
        return depth;
    }
    
    private void traverse(TreeNode root, int curtDepth) {
        if (root == null) {
            return;
        }
        
        depth = Math.max(depth, curtDepth);
        traverse(root.left, curtDepth + 1);
        traverse(root.right, curtDepth + 1);
    }
}