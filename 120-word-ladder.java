public class Solution {
    /*
     * @param start: a string
     * @param end: a string
     * @param dict: a set of string
     * @return: An integer
     */
    public int ladderLength(String start, String end, Set<String> dict) {
        
        if (dict == null) {
            return 0;
        }
        
        if (start.equals(end)) {
            return 1;
        }
        // confusion: why need add start and end to dict?
        dict.add(start);
        dict.add(end);
        
        Queue<String> queue = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        
        queue.offer(start);
        visited.add(start);
        
        int length = 1;
        
        while (!queue.isEmpty()) {
            length++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                for (String nextWord : getNextWords(word, dict)) {
                    if (visited.contains(nextWord)) {
                        continue;
                    }
                    if (nextWord.equals(end)) {
                        return length;
                    }
                    queue.offer(nextWord);
                    visited.add(nextWord);
                }
            }
        }
        return 0;
    }
    
    private List<String> getNextWords(String word, Set<String> dict) {
        List<String> result = new ArrayList<>();
        // length?
        for (int i = 0; i < word.length(); i++) {
            for (char j = 'a'; j <= 'z'; j++) {
                if (word.charAt(i) == j) {
                    continue;
                }
                String newWord = replace(word, i, j);
                if (dict.contains(newWord)) {
                    result.add(newWord);
                }
            }
        }
        return result;
    }
    
    private String replace(String word, int position, char character) {
        char[] chars = word.toCharArray();
        chars[position] = character;
        return new String(chars);
    }
}

// note:
// string.toCharArray();
// new String(char[]);
// the initital value of length and when to '++'';