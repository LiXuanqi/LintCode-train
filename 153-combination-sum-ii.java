public class Solution {
    /**
     * @param num: Given the candidate numbers
     * @param target: Given the target number
     * @return: All the combinations that sum to target
     */
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        // write your code here
        List<List<Integer>> result = new ArrayList<>();
        if (num == null || num.length == 0) {
            return result;
        }
        Arrays.sort(num);
        
        backtrack(0, new ArrayList<>(), result, target, num);
        
        return result;
    }
    private void backtrack(int start, List<Integer> temp, List<List<Integer>> result, int target, int[] num) {
        if (target == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i < num.length; i++) {
            if (num[i] > target) {
                break;
            }
            if (i != start && num[i] == num[i-1]) {
                continue;
            }
            temp.add(num[i]);
            backtrack(i + 1, temp, result, target - num[i], num);
            temp.remove(temp.size() - 1);
        }
    }
}