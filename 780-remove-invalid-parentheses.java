public class Solution {
    /**
     * @param s: The input string
     * @return: Return all possible results
     */
    public List<String> removeInvalidParentheses(String s) {
        int l = 0;
        int r = 0;
        List<String> result = new ArrayList<>();
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                l++;
            }
            if (s.charAt(i) == ')') {
                if (l > 0) {
                    l--;
                } else {
                    r++;
                }
            }
        }

        dfs(0, l, r, s, result);
        
        return result;
    }
    
    private void dfs(int start, int l, int r, String s, List<String> result) {
        if (l == 0 && r == 0) {
            if (isValid(s)) {
                result.add(s);
            }
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if (i != start && s.charAt(i) == s.charAt(i - 1)) {
                continue;
            }
            if (s.charAt(i) == '(') {
                String nextString = s.substring(0, i) + s.substring(i + 1);
                if (l > 0) {
                    // note: the start index of dfs.
                    // i not i + 1
                    // when you delete a character, character[i+1] become character[i];
                    dfs(i, l - 1, r, nextString, result);
                }
            }
            if (s.charAt(i) == ')') {
                String nextString = s.substring(0, i) + s.substring(i + 1);
                if (r > 0) {
                    dfs(i, l, r - 1, nextString, result);
                }
            }
        }
    }
    
    private boolean isValid(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                count++;
            }
            if (s.charAt(i) == ')') {
                if (count <= 0) {
                    return false;
                }
                count--;
            }
        }
        if (count == 0) {
            return true;
        }
        return false;
    }
}