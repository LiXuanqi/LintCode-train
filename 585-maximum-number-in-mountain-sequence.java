// Solution1: Bruteforce
// O(n)
public class Solution {
    /**
     * @param nums: a mountain sequence which increase firstly and then decrease
     * @return: then mountain top
     */
    public int mountainSequence(int[] nums) {
        // write your code here
        int max = nums[0];
        for (int num : nums) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }
}

// Solution2: Binary Search 
// O(logn)

public class Solution {
    /**
     * @param nums: a mountain sequence which increase firstly and then decrease
     * @return: then mountain top
     */
    public int mountainSequence(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]) {
                return nums[mid];
            }
            if (nums[mid] > nums[mid-1] && nums[mid] < nums[mid+1]) {
                start = mid;
            } else {
                end = mid;
            }
        }
        
        if (nums[start] < nums[end]) {
            return nums[end];
        } 
        if (nums[start] >= nums[end]) {
            return nums[start];
        }
        return -1;
    }
}