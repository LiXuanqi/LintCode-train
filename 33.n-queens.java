public class Solution {
    /*
     * @param n: The number of queens
     * @return: All distinct solutions
     */
    public List<List<String>> solveNQueens(int n) {
        List<List<Integer>> results = new ArrayList<>();
        boolean[] visited = new boolean[n + 1];
        dfs(results, new ArrayList<>(), n, visited);
        
        System.out.print(results);
        // draw board.
        List<List<String>> boards = new ArrayList<>();
        for (List<Integer> result : results) {
            List<String> board = drawBoard(result, n);
            boards.add(board);
        }
        return boards;
    }
    
    private void dfs(List<List<Integer>> results, List<Integer> temp, int n, boolean[] visited) {
        if (temp.size() == n) {
            if (isValid(temp)) {
                results.add(new ArrayList<>(temp));    
            }
        }
        for (int i = 1; i < n + 1; i++) {
            if (visited[i] == true) {
                continue;
            }
            temp.add(i);
            visited[i] = true;
            dfs(results, temp, n, visited);
            temp.remove(temp.size() - 1);
            visited[i] = false;
        }
    }
    // [1, 2, 3]
    // [2, 3, 1]
    // index - x
    // val - y
    // delta index = delta val
    private boolean isValid(List<Integer> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if ((j - i) == Math.abs(list.get(j) - list.get(i))) {
                    return false;
                }

            }
        }
        return true;
    }
    private List<String> drawBoard(List<Integer> positions, int n) {
        List<String> board = new ArrayList<>();
        for (int i = 0; i < positions.size(); i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                sb.append(j + 1 == positions.get(i) ? 'Q' : '.');
            }
            board.add(sb.toString());
        }
        return board;
    }
}
