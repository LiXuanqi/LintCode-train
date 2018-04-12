public class Solution {
    /**
     * @param n: Given the range of numbers
     * @param k: Given the numbers of combinations
     * @return: All the combinations of k numbers out of 1..n
     */
    public List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> result = new ArrayList<>();
        backtrack(1, result, new ArrayList<>(), k, n);
        return result;
    }
    private void backtrack(int start, List<List<Integer>> result, List<Integer> temp, int k, int n) {
        if (temp.size() == k) {
            result.add(new ArrayList<>(temp));
        }
        for (int i = start ; i <= n; i++) {
            temp.add(i);
            backtrack(i + 1, result, temp, k, n);
            temp.remove(temp.size() - 1);
        }
    }
}