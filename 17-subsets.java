public class Solution {
    /**
     * @param nums: A set of numbers
     * @return: A list of lists
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null) {
            return result;
        }
        if (nums.length == 0) {
            result.add(new ArrayList<>());
        }
        Arrays.sort(nums);

        backtrack(0, new ArrayList<Integer>(), result, nums);
        return result;
    }
    private void backtrack(int start, ArrayList<Integer> temp, List<List<Integer>> result, int[] nums) {
        if (!result.contains(temp)) {
            // note: deep copy OR return [];
            result.add(new ArrayList<Integer>(temp));
        }
        for (int i = start; i < nums.length; i++) {
            temp.add(nums[i]);
            backtrack(i+1, temp, result, nums);
            temp.remove(temp.size()-1);
        }
    }
}