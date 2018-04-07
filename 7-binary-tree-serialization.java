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
     * This method will be invoked first, you should design your own algorithm 
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    public String serialize(TreeNode root) {
        // write your code here
        if (root == null) {
            return null;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        List<String> result = new ArrayList<>();
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode head = queue.poll();
                if (head == null) {
                    result.add("#");
                    continue;
                }
                result.add(Integer.toString(head.val));
                
                queue.offer(head.left);
                queue.offer(head.right);
                
            }
        }
        String rawString = result.toString();
        String string = rawString.substring(1, rawString.length() - 1);
        System.out.print(string);
        return string;
    }

    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in 
     * "serialize" method.
     */
    public TreeNode deserialize(String data) {
        // write your code here
        if (data == null) {
            return null;
        }
        
        String[] vals = data.split(", ");
        
        List<TreeNode> list = new ArrayList<>();
        int index = 0;
        boolean isLeftTree = true;
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        list.add(root);
        for (int i = 1; i < vals.length; i++) {
            if (!vals[i].equals("#")) {
                TreeNode node = new TreeNode(Integer.parseInt(vals[i]));
                
                if (isLeftTree) {
                    list.get(index).left = node;
                    
                } else {
                    list.get(index).right = node;
                }
                list.add(node);
                
            }
            if (!isLeftTree) {
                index++;
            }
            
            isLeftTree = !isLeftTree;
        }
        
        return root;
    }
}

// note:
// 1.Integer.toString(num); string to int.