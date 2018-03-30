public class Solution {
    /**
     * @param A: an integer rotated sorted array
     * @param target: an integer to be searched
     * @return: an integer
     */
    public int search(int[] A, int target) {
        // write your code here
        if (A == null || A.length == 0) {
            return -1;
        }
        
        int start = 0;
        int end = A.length - 1;
        int pivot = A[start];
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (target >= pivot) {
                if (A[mid] < target && A[mid] > pivot) {
                    start = mid;
                } else {
                    end = mid;
                }
            } else {
                if (A[mid] < pivot && A[mid] > target) {
                    end = mid;
                } else {
                    start = mid;
                }
            }
        }
        if (A[start] == target) {
            return start;
        }
        if (A[end] == target) {
            return end;
        }
        return -1;
    }
}