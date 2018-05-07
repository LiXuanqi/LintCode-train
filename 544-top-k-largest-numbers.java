public class Solution {
    /**
     * @param nums: an integer array
     * @param k: An integer
     * @return: the top k largest numbers in array
     */
    public int[] topk(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);
        // note: left - right  minHeap
        
        for (int num : nums) {
            int min = Integer.MIN_VALUE;
            if (minHeap.size() == k) {
                min = minHeap.poll();
            }
            
            minHeap.offer(num > min ? num : min);
        }
        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = minHeap.poll();
        }
        return result;
    }
}

// note: it could be solved in O(n).
// quick select.