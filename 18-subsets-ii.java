public class Solution {
    /**
     * @param nums: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null) {
            return result;
        }
        if (nums.length == 0) {
            result.add(new ArrayList<>());
            return result;
        }
        
        Arrays.sort(nums);
        
        backtrack(0, new ArrayList<>(), result, nums);
        
        return result;
    }
    private void backtrack(int start, List<Integer> temp, List<List<Integer>> result, int[] nums) {
        result.add(new ArrayList<>(temp));
        for (int i = start; i < nums.length; i++) {
            // note： i != start NOT i > 0;
            // [1,1] => [1] error!
            if (i != start && nums[i] == nums[i - 1]) {
                continue;
            }
            temp.add(nums[i]);
            backtrack(i+1, temp, result, nums);
            temp.remove(temp.size() - 1);
        }
    }
}