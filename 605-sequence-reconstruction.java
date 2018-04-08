public class Solution {
    /**
     * @param org: a permutation of the integers from 1 to n
     * @param seqs: a list of sequences
     * @return: true if it can be reconstructed only one or false
     */
    public boolean sequenceReconstruction(int[] org, int[][] seqs) {
        
        // case: [1] [0]
        int count = 0;

        HashMap<Integer, HashSet<Integer>> edges = new HashMap<>();
        HashMap<Integer, Integer> indegree = new HashMap<>();
        
        for (int i = 0; i< seqs.length; i++) {
            // calculate the total number of seqs.
            count = count + seqs[i].length;
            
            // case: [1] [[1],[100000000]]
            if (seqs[i].length == 1 && (seqs[i][0] < 1 || seqs[i][0] > org.length)) {
                return false;
            }
            
            // edges
            for (int j = 1; j < seqs[i].length; j++) {
                
                if (!edges.containsKey(seqs[i][j-1])) {
                    edges.put(seqs[i][j-1], new HashSet<Integer>());
                }
                edges.get(seqs[i][j-1]).add(seqs[i][j]);
            }
            
        }
        
        if (count < org.length) {
            return false;
        }
        
        // indegree
        for (int key : edges.keySet()) {
            for (int neighbor : edges.get(key)) {
                if (!indegree.containsKey(neighbor)) {
                    indegree.put(neighbor, 0);
                }
                indegree.put(neighbor, indegree.get(neighbor) + 1);
            }
        }
            
        // System.out.print(edges);
        // System.out.print(indegree);
        
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        

        for (int i = 1; i <= org.length; i++) {
            
            if (indegree.containsKey(i)) {
                continue;
            }
            queue.offer(i);
    
        }
        
        // System.out.print(queue);
        
        while (!queue.isEmpty()) {
            // System.out.print(queue);
            if (queue.size() != 1) {
                return false;
            }
            
            int head = queue.poll();
            // System.out.print(head);
            list.add(head);
            
            if (!edges.containsKey(head)) {
                continue;
            }
            
            for (int neighbor : edges.get(head)) {
                indegree.put(neighbor, indegree.get(neighbor) - 1);
                if (indegree.get(neighbor) == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        
        ArrayList<Integer> raw = new ArrayList<Integer>();
        for (int i : org) {
            raw.add(i);
        }
        // System.out.print(raw.toString());
        // System.out.print(list.toString());
        if (raw.toString().equals(list.toString())) {
            return true;
        }
        return false;
    }
}

// note: 
// 1. calculate indegree
// error method: when seqs = [[5, 2, 6, 3], [4, 1, 5, 2]]
// the indegree of 2 will be 2.

// for (int j = 1; j < seqs[i].length; j++) {
//     if (!indegree.containsKey(seqs[i][j])) {
//         indegree.put(seqs[i][j], 0);
//     }
//     indegree.put(seqs[i][j], indegree.get(seqs[i][j]) + 1);
// }
//