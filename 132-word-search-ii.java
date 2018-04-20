public class Solution {
    /**
     * @param board: A list of lists of character
     * @param words: A list of string
     * @return: A list of string
     */
    class Coordinate {
        int x, y;
        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    private int[] directionX = new int[] {0, 0, 1, -1};
    private int[] directionY = new int[] {1, -1, 0, 0};
    public List<String> wordSearchII(char[][] board, List<String> words) {
        
        HashMap<String, Boolean> dict = getPrefixDict(words);
        List<String> result = new ArrayList<>();
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                StringBuilder sb = new StringBuilder();
                sb.append(board[i][j]);
                visited[i][j] = true;
                dfs(board, sb, result, dict, visited, new Coordinate(i, j));
                visited[i][j] = false;
            }
        }
        
        return result;
    }
    
    private void dfs(char[][] board, StringBuilder temp, List<String> result, HashMap<String, Boolean> dict, boolean[][] visited, Coordinate coordinate) {
        System.out.print(temp.toString() + " ");
        if (!dict.containsKey(temp.toString())) {
            return;
        }
        if (dict.get(temp.toString()) == true) {
            if (!result.contains(temp.toString())) {
               result.add(temp.toString());
            }
       
            // note : not return; "se" "see" when find "se", if return will miss "see"
        }
        for (int i = 0; i < 4; i++) {
            
            Coordinate nextCoordinate = new Coordinate(coordinate.x + directionX[i], coordinate.y + directionY[i]);
            if (!isValid(nextCoordinate, board)) {
                continue;
            }
            if (visited[nextCoordinate.x][nextCoordinate.y] == true) {
                continue;
            }
            
            char character = board[nextCoordinate.x][nextCoordinate.y];
            temp.append(character);
            visited[nextCoordinate.x][nextCoordinate.y] = true;
            dfs(board, temp, result, dict, visited, nextCoordinate);
            temp.deleteCharAt(temp.length() - 1);
            visited[nextCoordinate.x][nextCoordinate.y] = false;
        }
    }
    
    private boolean isValid(Coordinate coor, char[][] board) {
        int row = board.length - 1;
        int col = board[0].length - 1;
  
        return 0 <= coor.x && coor.x <= row && 0 <= coor.y && coor.y <= col;
    }
    
    private HashMap<String, Boolean> getPrefixDict(List<String> words) {
        HashMap<String, Boolean> dict = new HashMap<>();
        
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                if (i == word.length() - 1) {
                    dict.put(word.substring(0, i + 1), true);
                    continue;
                }
                if (dict.containsKey(word.substring(0, i + 1)) && dict.get(word.substring(0, i + 1)) == true) {
                    continue;
                }
                dict.put(word.substring(0, i + 1), false);
            }
        }
        return dict;
    }
}