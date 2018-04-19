public class Solution {
    /*
     * @param start: a string
     * @param end: a string
     * @param dict: a set of string
     * @return: a list of lists of string
     */
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        dict.add(start);
        dict.add(end);
        HashMap<String, Integer> distanceMap = getDistance(start, end, dict);
        List<List<String>> result = new ArrayList<>();
        
        dfs(result, new ArrayList<>(), dict, 1, end, start, distanceMap);
        for (List<String> list : result) {
            list.add(end);
        }
        return result;
    }
    
    private void dfs(List<List<String>> result, List<String> temp, Set<String> dict, int distance, String start, String target, HashMap<String, Integer> map) {
        if (start.equals(target)) {
            Collections.reverse(temp);
            result.add(new ArrayList<>(temp));
            // why need reverse temp again?
            Collections.reverse(temp);
            return;
        }
  
        for (String word : getNextWords(start, dict)) {
            if (map.get(word) != distance) {
                continue;
            }

            temp.add(word);
  
            dfs(result, temp, dict, distance + 1, word, target, map);
            temp.remove(temp.size() - 1);
        }
    }
    
    private HashMap<String, Integer> getDistance(String start, String end, Set<String> dict) {
        // bfs from end to start.
        HashMap<String, Integer> map = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        
        queue.offer(end);
        visited.add(end);
        
        int distance = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String node = queue.poll();
                if (!map.containsKey(node)) {
                    map.put(node, distance);
                }
                for (String word : getNextWords(node, dict)) {
                    if (visited.contains(word)) {
                        continue;
                    }
            
                    queue.offer(word);
                    visited.add(word);
                }
            }
            distance++;
        }
        return map;
    }
    
    private List<String> getNextWords(String word, Set<String> dict) {
        List<String> words = new ArrayList<>();
        
        for (int i = 0; i < word.length(); i++) {
            for (char j = 'a'; j <= 'z'; j++) {
                if (word.charAt(i) == j) {
                    continue;
                }
                String newWord = replace(word, i, j);
                if (dict.contains(newWord)) {
                    words.add(newWord);
                }
            }
        }
        return words;
    }
    
    private String replace(String word, int position, char character) {
        char[] chars = word.toCharArray();
        chars[position] = character;
        return new String(chars);
    }
}

