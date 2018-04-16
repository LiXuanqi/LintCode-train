public class Solution {
    /*
     * @param :  A list of integers
     * @return: A list of unique permutations
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        
        if (nums == null) {
            return null;
        }
        if (nums.length == 0) {
            result.add(new ArrayList<>());
            return result;
        }
        
        boolean[] visited = new boolean[nums.length];
        
        Arrays.sort(nums);
        backtrack(new ArrayList<>(), result, visited, nums);
        return result;
    }
    private void backtrack(List<Integer> temp, List<List<Integer>> result, boolean[] visited, int[] nums) {
        if (temp.size() == nums.length) {
            result.add(new ArrayList<>(temp));
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == true) {
                continue;
            }
            if (i != 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                continue;
            }
            temp.add(nums[i]);
            visited[i] = true;
            backtrack(temp, result, visited, nums);
            temp.remove(temp.size() - 1);
            visited[i] = false;
        }
    }
};