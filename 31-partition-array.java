public class Solution {
    /**
     * @param nums: The integer array you should partition
     * @param k: An integer
     * @return: The index after partition
     */
    public int partitionArray(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // write your code here
        int left = 0;
        int right = nums.length - 1;
        int pivot = k;
        
        while (left <= right) {
            while (left <= right && nums[left] < pivot) {
                left++;
            }
            while (left <= right && nums[right] >= pivot) {
                right--;
            }
            if (left <= right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                
                left++;
                right--;
            }
        }
        
        return left; // why return left; why can include the situation that all elements in nums are smaller than k, then return nums.length
    }
    // 3(l) 2 2 1(r)
    // 1(l) 2 2 3(r)
    // 1 2(l) 2(r) 3
    // 1 2(l)(r) 2 3
    // 1(r) 2(l) 2 3
    
}

// note : 
// when right - num - left?
// left == right == pivot.
// in quicksort , 2 'while' will not execute, and then left++ right--;
// in this question, because nums[right] >= pivot, when left == right,only one of the two 'while' will execute.
// and then left>right, 'if' will not execute.