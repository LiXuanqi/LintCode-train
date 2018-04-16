public class Solution {
    /**
     * @param str: A string
     * @return: all permutations
     */
    public List<String> stringPermutation2(String str) {
        List<String> result = new ArrayList<>();
        
        char[] s = str.toCharArray();
        Arrays.sort(s);
        boolean[] visited = new boolean[s.length];
        backtrack(new StringBuilder(), result, visited, s);
        
        return result;
    }
    
    private void backtrack(StringBuilder temp, List<String> result, boolean[] visited, char[] s) {
        if (temp.length() == s.length) {
            result.add(temp.toString());
        }
        for (int i = 0; i < s.length; i++) {
            if (visited[i]) {
                continue;
            }
            if (i != 0 && s[i - 1] == s[i] && !visited[i - 1]) {
                continue;
            }
            temp.append(s[i]);
            visited[i] = true;
            backtrack(temp, result, visited, s);
            temp.deleteCharAt(temp.length() - 1);
            visited[i] = false;
        }
    }
}