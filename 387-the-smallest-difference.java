public class Solution {
    /**
     * @param A: An integer array
     * @param B: An integer array
     * @return: Their smallest difference.
     */
    private int minDiff = Integer.MAX_VALUE;
    public int smallestDifference(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        for (int a : A) {
            int b = findClosetNumber(B, a);
            int diff = Math.abs(b - a);
            
            if (diff == 0) {
                return 0;
            }
            
            if (diff < minDiff) {
                minDiff = diff;
            }
        }
        return minDiff;
    }
    private int findClosetNumber(int[] list, int target) {
        int start = 0;
        int end = list.length - 1;
        while (start < end - 1) {
            int mid = start + (end - start) / 2;
            if (target == list[mid]) {
                return target;
            }
            if (target < list[mid]) {
                end = mid;
            }
            if (target > list[mid]) {
                start = mid;
            }
        }
        if (Math.abs(target - list[start]) < Math.abs(target - list[end]) ) {
            return list[start];
        } else {
            return list[end];
        }
    }
}