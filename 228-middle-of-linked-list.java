/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */


public class Solution {
    /*
     * @param head: the head of linked list.
     * @return: a middle node of the linked list
     */
    public ListNode middleNode(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode left = head;
        ListNode right = head;
        while (right.next != null) {
            right = right.next;
            right = right.next;
            if (right == null) {
                return left;
            }
            left = left.next;
        }
        return left;
    }
}