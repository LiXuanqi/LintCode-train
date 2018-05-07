/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */ 
public class Solution {
    /**
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    public ListNode mergeKLists(List<ListNode> lists) {  
        if (lists.size() == 0 || lists == null) {
            return null;
        }
        PriorityQueue<ListNode> heap = new PriorityQueue<>(lists.size(), new Comparator<ListNode>() {
            public int compare(ListNode left, ListNode right) {
                return left.val - right.val;
            }
        });
        
        for (int i = 0; i < lists.size(); i++) {
            if (lists.get(i) != null) {
                heap.offer(lists.get(i));      
            }
        }
      
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        
        while (!heap.isEmpty()) {
            ListNode node = heap.poll();
            ListNode newNode = new ListNode(node.val);
            tail.next = newNode;
            tail = newNode;
            if (node.next != null) {
                heap.offer(node.next);
            }
        }
        
        return dummy.next;
    }
}
