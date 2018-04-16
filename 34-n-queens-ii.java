public class Solution {
    /**
     * @param n: The number of queens.
     * @return: The total number of distinct solutions.
     */
    private int count = 0;
    public int totalNQueens(int n) {
        boolean[] visited = new boolean[n + 1];
        dfs(new ArrayList<>(), n, visited);
        return count;
    }
    private void dfs(List<Integer> temp, int n, boolean[] visited) {
        if (temp.size() == n) {
            if (isValid(temp)) {
                count++;
            }
        }
        
        for (int i = 1; i < n + 1; i++) {
            if (visited[i]) {
                continue;
            }
            temp.add(i);
            visited[i] = true;
            dfs(temp, n, visited);
            temp.remove(temp.size() - 1);
            visited[i] = false;
        }
    }
    private boolean isValid(List<Integer> positions) {
        for (int i = 0; i < positions.size() - 1; i++) {
            for (int j = i + 1; j < positions.size(); j++) {
                if ((j - i) == Math.abs(positions.get(j) - positions.get(i))) {
                    return false;
                }
            }
        }
        return true;
    }
}