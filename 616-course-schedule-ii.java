public class Solution {
    /*
     * @param numCourses: a total of n courses
     * @param prerequisites: a list of prerequisite pairs
     * @return: the course order
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // write your code here
        List[] edges = new ArrayList[numCourses];
        int[] degree = new int[numCourses];
        
        for (int i = 0; i < numCourses; i++) {
            edges[i] = new ArrayList<Integer>();
        }
        
        for (int i = 0; i < prerequisites.length; i++) {
            degree[prerequisites[i][0]]++;
            edges[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        
        Queue<Integer> queue = new LinkedList<>();
        int[] result = new int[numCourses];
        
        for (int i = 0; i < degree.length; i++) {
            if (degree[i] == 0) {
                queue.offer(i);
            }
        }
        int count = 0;
        while (!queue.isEmpty()) {
            int head = queue.poll();
            result[count] = head;
            count++;
            
            int size = edges[head].size();
            for (int i = 0; i < size; i++) {
                int neighbor = (int) edges[head].get(i);
                degree[neighbor]--;
                if (degree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        if (count != numCourses) {
            return new int[0]; // "[]"
        }
        return result;
    }
}