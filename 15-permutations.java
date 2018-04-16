public class Solution {
    /*
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public List<List<Integer>> permute(int[] nums) {
        // write your code here
        List<List<Integer>> result = new ArrayList<>();
        boolean[] visited = new boolean[nums.length]; // default value is false.
        if (nums == null) {
            return null;
        }
        if (nums.length == 0) {
            result.add(new ArrayList<>());
            return result;
        }
        backtrack(new ArrayList<>(), result, nums, visited);
        return result;
    }
    private void backtrack(List<Integer> temp, List<List<Integer>> result, int[] nums, boolean[] visited) {
        if (temp.size() == nums.length) {
            result.add(new ArrayList<>(temp));
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == true) {
                continue;
            }
            temp.add(nums[i]);
            visited[i] = true;
            backtrack(temp, result, nums, visited);
            temp.remove(temp.size() - 1);
            visited[i] = false;
        }
    }
}