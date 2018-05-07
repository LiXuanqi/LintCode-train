public class Solution {
    /**
     * @param n: An integer
     * @return: the nth prime number as description.
     */
    public int nthUglyNumber(int n) {
        if (n <= 0) {
            return -1;
        }
        
        Set<Long> set = new HashSet<>();
        // note: heap.poll() is from min to max.
        PriorityQueue<Long> heap = new PriorityQueue<>();
        heap.offer((long) 1);
        int uglyNum = 1;
        while (n != 0) {
            uglyNum = findNextUglyNumber(heap, set);   
          
            n--;
        }
        return uglyNum;
    }
    
    private int findNextUglyNumber(PriorityQueue<Long> heap, Set<Long> set) {
        long result = heap.poll();
        int[] list = {2, 3, 5};
        for (int factor : list) {
            long newNum = result * factor;
            if (!set.contains(newNum)) {
                heap.offer(newNum);
                set.add(newNum);
                // System.out.print("2"+ result * 2);
            }
        }
      
    
        return (int) result;
    }
}