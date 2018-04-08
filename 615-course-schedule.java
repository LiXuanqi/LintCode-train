public class Solution {
    /*
     * @param numCourses: a total of n courses
     * @param prerequisites: a list of prerequisite pairs
     * @return: true if can finish all courses or false
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // write your code here
        List[] edges = new ArrayList[numCourses];
        int[] degree = new int[numCourses];
        
        for (int i = 0; i < numCourses; i++) {
            edges[i] = new ArrayList<Integer>();
        }
        
        for (int j = 0; j < prerequisites.length; j++) {
            degree[prerequisites[j][0]]++;
            edges[prerequisites[j][1]].add(prerequisites[j][0]);
        }
        
        Queue<Integer> queue = new LinkedList<>();
        
        for (int k = 0; k < numCourses; k++) {
            if (degree[k] == 0) {
                queue.offer(k);
            }
        }
        
        int count = 0;
        
        while (!queue.isEmpty()) {
            int head = queue.poll();
            count++;

            int size = edges[head].size();
            for (int n = 0; n < size; n++) {
                int neighbor = (int) edges[head].get(n);
                degree[neighbor] --;
                if (degree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
       
            
        }
        
        if (count == numCourses) {
            return true;
        }
        return false;
        
    }
}