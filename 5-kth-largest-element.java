class Solution {
    /*
     * @param k : description of k
     * @param nums : array of nums
     * @return: description of return
     */
    public int kthLargestElement(int k, int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return -1;
        }
        
        return quickSelect(nums, 0, nums.length - 1, k);
    }
    
    private int quickSelect(int[] nums, int start, int end, int k) {
        if (start == end) {
            return nums[start];
        }
        
        int left = start;
        int right = end;
        int pivot = nums[(start + end) / 2];
        
        while (left <= right) {
            // noto: nums[left] > pivot not <
            // because: largest ~ descending order.
            while (left <= right && nums[left] > pivot) {
                left++;
            }
            while (left <= right && nums[right] < pivot) {
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
        // why need -1?
        if (start + k - 1 <= right) {
            // note: should return quickSelect, not just execute quickSelect.
            return quickSelect(nums, start, right, k);
        }
        if (start + k - 1 >= left) {
            // why kth = k - (left - start)?
            // two situation:
            // (1) right - num - left 
            // (2) right - left
            return quickSelect(nums, left, end, k - (left - start));
        }
        return nums[right + 1];
    }
};