public class Solution {
    /**
     * @param candidates: A list of integers
     * @param target: An integer
     * @return: A list of lists of integers
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return null;
        }
        
        List<List<Integer>> result = new ArrayList<>();
        
        Arrays.sort(candidates);
        backtrack(0, new ArrayList<>(), result, candidates, target);
        
        return result;
    }
    private void backtrack(int start, List<Integer> temp, List<List<Integer>> result, int[] candidates, int target) {
        if (target == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            // note : target could be minus. if ignore, it will never equals 0, and then stack overflow.
            if (candidates[i] > target) {
                break;
            }
            // imporve: not calculate the duplicated element.
            if (i != start && candidates[i] == candidates[i-1]) {
                continue;
            }
            temp.add(candidates[i]);
            backtrack(i, temp, result, candidates, target - candidates[i]);
            temp.remove(temp.size() - 1);
        }

    }
}