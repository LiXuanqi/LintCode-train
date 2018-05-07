/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * } * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */

public class Solution {
    /**
     * @param points: a list of points
     * @param origin: a point
     * @param k: An integer
     * @return: the k closest points
     */
    public Point[] kClosest(Point[] points, Point origin, int k) {
        PriorityQueue<Point> heap = new PriorityQueue<>(k, new Comparator<Point>() {
            public int compare(Point left, Point right) {
                long distanceLeft = calculateDistance(left, origin);
                long distanceRight = calculateDistance(right, origin);
                return (int) (distanceRight - distanceLeft);
            }
        });
        
        for (Point point : points) {

            Point oldNode = new Point(Integer.MAX_VALUE, Integer.MAX_VALUE);
            if (heap.size() == k) {
                oldNode = heap.poll();
            }
            
            if (calculateDistance(point, origin) < calculateDistance(oldNode, origin)) {
                heap.offer(point);
            } else {
                heap.offer(oldNode);
            }
           
        }
        
        Point[] result = new Point[k];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = heap.poll();
        }
        
        return result;
        
    }
    
    private long calculateDistance(Point point, Point origin) {
        return  (long) (point.x - origin.x) * (long) (point.x - origin.x) + (long) (point.y - origin.y) * (long) (point.y - origin.y);
    }
}