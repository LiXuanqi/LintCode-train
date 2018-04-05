/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */


public class Solution {
    /*
     * @param node: A undirected graph node
     * @return: A undirected graph node
     */
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        // write your code here
        if (node == null) {
            return null;
        }
        // find all nodes.
        List<UndirectedGraphNode> nodes = findAllGraphNodes(node);
        // copy nodes.
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = cloneAllNodes(nodes);
        // connect nodes.
        for (UndirectedGraphNode oldNode : nodes) {
            UndirectedGraphNode newNode = map.get(oldNode);
            for (UndirectedGraphNode oldNeighbor : oldNode.neighbors) {
                UndirectedGraphNode newNeighbor = map.get(oldNeighbor);
                newNode.neighbors.add(newNeighbor);
            }
        }
        
        return map.get(node);
    }
    
    private List<UndirectedGraphNode> findAllGraphNodes(UndirectedGraphNode node) {
        
        
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        HashSet<UndirectedGraphNode> visited = new HashSet<>();
        
        queue.offer(node);
        visited.add(node);

        
        while (!queue.isEmpty()) {
            UndirectedGraphNode head = queue.poll();
            for (UndirectedGraphNode neighbor : head.neighbors) {
                if (!visited.contains(neighbor)) {
                    queue.offer(neighbor);
                    visited.add(neighbor);
                }
            }
        }
        
        return new ArrayList<>(visited);
    }
    
    private HashMap<UndirectedGraphNode, UndirectedGraphNode> cloneAllNodes(
        List<UndirectedGraphNode> oldNodes
    ) {
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        for (UndirectedGraphNode n : oldNodes) {
            map.put(n, new UndirectedGraphNode(n.label));
        }
        return map;
    }
}

// note:
// hashMap.put(key, value);
// hashMap.get(key);