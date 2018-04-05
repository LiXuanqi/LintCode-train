/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */

public class Solution {
    /**
     * @param grid: a chessboard included 0 (false) and 1 (true)
     * @param source: a point
     * @param destination: a point
     * @return: the shortest path 
     */
    public int shortestPath(boolean[][] grid, Point source, Point destination) {
        if (grid == null || grid.length == 0) {
            return -1;
        }
        
        Queue<Point> queue = new LinkedList<>();
        
        int step = 0;
        
        queue.offer(source);
        grid[source.x][source.y] = true;
        
        int[] directionX = new int[]{1, 1, -1, -1, 2, 2, -2 , -2};
        int[] directionY = new int[]{2, -2, 2, -2, 1, -1, 1, -1};
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Point head = queue.poll();
                if (head.x == destination.x && head.y == destination.y) {
                    return step;
                }
                for (int j = 0; j < 8; j++ ) {
                    
                    Point adj = new Point(head.x + directionX[j], head.y + directionY[j]);
                    if (!isInBound(adj, grid)) {
                        continue;
                    }
                    if (grid[adj.x][adj.y]) {
                        continue;
                    }
                    queue.offer(adj);
                    grid[adj.x][adj.y] = true;
                }
                
            }
            step++;
            
        }
        return -1;
    }
    
    private boolean isInBound(Point p, boolean[][] grid) {
        int n = grid.length - 1;
        int m = grid[0].length - 1;
        return p.x >= 0 && p.x <= n && p.y >=0 && p.y <= m;
    }
}