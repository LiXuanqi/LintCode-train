public class Solution {
    /**
     * @param nums: an array of Integer
     * @param target: target = nums[index1] + nums[index2]
     * @return: [index1 + 1, index2 + 1] (index1 < index2)
     */
    public int[] twoSum(int[] nums, int target) {
        // write your code here
        int left = 0;
        int right = nums.length - 1;
        
        while (left != right) {
            if (nums[left] == target - nums[right]) {
                return new int[]{left + 1, right + 1};
            }
            
            if (nums[left] < target - nums[right]) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{0, 0};
    }
}