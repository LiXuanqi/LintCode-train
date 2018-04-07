/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
 * };
 */

public class Solution {
    /*
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        HashMap<DirectedGraphNode, Integer> map = findAllIndegree(graph);
        
        Queue<DirectedGraphNode> queue = new LinkedList<>();
        ArrayList<DirectedGraphNode> result = new ArrayList<>();
        
        for (DirectedGraphNode node : graph) {
            // find the node whose indegree = 0;
            if (!map.containsKey(node)) {
                queue.offer(node);
            }
        }
        while (!queue.isEmpty()) {
            
            DirectedGraphNode head = queue.poll();
            result.add(head);
            
            for (DirectedGraphNode neighbor : head.neighbors) {
                map.put(neighbor, map.get(neighbor) - 1);
                if (map.get(neighbor) == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        
        return result;
    }
    
    private HashMap<DirectedGraphNode, Integer> findAllIndegree(
        ArrayList<DirectedGraphNode> graph
    ) {
        HashMap<DirectedGraphNode, Integer> map = new HashMap<>();

        for (DirectedGraphNode node : graph) {
            // note:
            // not put the node into the map,
            // because: if the map not contains the key, it means that the indegree is 0;
            for (DirectedGraphNode neighbor : node.neighbors) {
                if (!map.containsKey(neighbor)) {
                    map.put(neighbor, 1);
                } else {
                    map.put(neighbor, map.get(neighbor) + 1);
                }
            }
        }
        
        return map;
    }
}