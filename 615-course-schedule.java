public class Solution {
    /*
     * @param numCourses: a total of n courses
     * @param prerequisites: a list of prerequisite pairs
     * @return: true if can finish all courses or false
     */
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        
        HashMap<Integer, HashSet<Integer>> graph = buildGraph(prerequisites);
        HashMap<Integer, Integer> map = findAllIndegree(graph);
        Queue<Integer> queue = new LinkedList<>();
        
        int count = 0;
        
        for (int i = 0; i < numCourses; i++) {
            if (!map.containsKey(i)) {
                queue.offer(i);        
            }
        }
        while (!queue.isEmpty()) {
            int head = queue.poll();
            count++;
            System.out.print(head);
            if (graph.containsKey(head)) {
                for (int neighbor : graph.get(head)) {
                    map.put(neighbor, map.get(neighbor) - 1);
                    if (map.get(neighbor) == 0) {
                        queue.offer(neighbor);
                    }
                }
            }
        }
        
        if (count == numCourses) {
            return true;
        } else {
            return false;
        }
    }
    
    private HashMap<Integer, HashSet<Integer>> buildGraph(int[][] prerequisites) {
        
        HashMap<Integer, HashSet<Integer>> graph = new HashMap<>();
        
        for (int[] course : prerequisites) {
            // course[0] : course name;
            // course[1] : prerequisites;
            if (!graph.containsKey(course[1])) {
                graph.put(course[1], new HashSet<>());
            }
            graph.get(course[1]).add(course[0]);
        }
        System.out.print(graph);
        return graph;
    }
    
    private HashMap<Integer, Integer> findAllIndegree(HashMap<Integer, HashSet<Integer>> graph) {

        HashMap<Integer, Integer> map = new HashMap<>();
        
        // hashmap traversal
        Iterator iter = graph.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            Object key = entry.getKey();
            HashSet<Integer> val = (HashSet<Integer>) entry.getValue();
            for (int neighbor : val) {
                if (!map.containsKey(neighbor)) {
                    map.put(neighbor, 0);
                }
                map.put(neighbor, map.get(neighbor) + 1);
            }
        }
        
        return map;
    }
}

// note: 
// 1. how to remove the duplicated elements from int[][];
// error method: 
// int[][] -> ArrayList<int[]> -> Set<int[]>
// (1) Arrays.asList(T[]) array to list.
// (2) set can't remove the duplicated elements of objects. (address is difficult [1, 9] [1, 9])

