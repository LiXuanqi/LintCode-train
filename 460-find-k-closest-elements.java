public class Solution {
    /**
     * @param A: an integer array
     * @param target: An integer
     * @param k: An integer
     * @return: an integer array
     */
    public int[] kClosestNumbers(int[] A, int target, int k) {
        // if the input is invalid, return what?
        int left = findClosestPosition(A, target);
        int right = left + 1;
        int[] result = new int[k];
        
        for (int i = 0; i < k; i++) {
            if (isLeftCloser(A, target, left, right)) {
                result[i] = A[left];
                left--;
            } else {
                result[i] = A[right];
                right++;
            }
        }
        
        return result;
        
    }
    
    private int findClosestPosition(int[] A, int target) {
        int start = 0;
        int end = A.length - 1;
        
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] <= target ) {
                start = mid;
            } else {
                end = mid;
            }
        }
        
        return start;
    }
    
    private boolean isLeftCloser(int[] A, int target, int left, int right) {
        if (left < 0) {
            return false;
        }
        
        if (right > A.length - 1) {
            return true;
        }
        
        if (target - A[left] <= A[right] - target) {
            return true;
        } else {
            return false;
        }
    }
}