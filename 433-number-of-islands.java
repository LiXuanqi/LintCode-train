public class Solution {
    /**
     * @param grid: a boolean 2D matrix
     * @return: an integer
     */
    class Coordinate {
        int x,y;
        public Coordinate(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    public int numIslands(boolean[][] grid) {
        if (grid == null) {
            return -1;
        }
        if (grid.length == 0) {
            return 0;
        }
        
        int number = 0;
        
        int n = grid.length;
        int m = grid[0].length;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j]) {
                    markByBFS(new Coordinate(i, j), grid);
                    number++;
                }
            }
        }
        return number;
    }
    
    private void markByBFS(Coordinate coor, boolean[][] grid) {
        int[] directionX = new int[]{-1, 1, 0, 0};
        int[] directionY = new int[]{0, 0, 1, -1};
        
        Queue<Coordinate> queue = new LinkedList<>();
   
        queue.offer(coor);
        
        while (!queue.isEmpty()) {
            Coordinate head = queue.poll();
            grid[head.x][head.y] = false;
      
            for (int i = 0; i < 4; i++) {
                if (!isInBound(head.x + directionX[i], head.y + directionY[i], grid)) {
                    continue;
                }
                if (grid[head.x + directionX[i]][head.y + directionY[i]]) {
                    queue.offer(new Coordinate(head.x + directionX[i], head.y + directionY[i]));
                }
            }
        }
 
    }
    
    private boolean isInBound(int x, int y, boolean[][] grid) {
        int n = grid.length - 1;
        int m = grid[0].length - 1;
        return x >= 0 && x <= n && y >=0 && y <= m;
    }
}