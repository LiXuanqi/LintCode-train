public class Solution {
    /**
     * @param n: An integer
     * @param str: a string with number from 1-n in random order and miss one number
     * @return: An integer
     */
    public int findMissing2(int n, String str) {
        // write your code here
        if (str == null || str.length() == 0) {
            return -1;
        }
        
        List<List<String>> result = new ArrayList<>();
        
        backtrack(0, n, new HashSet<>(), result, str);
        
        boolean[] happened = new boolean[n + 1];
        for (int i = 0; i < n + 1; i++) {
            happened[i] = false;
        }
        happened[0] = true;
        for (String s : result.get(0)) {
            int val = Integer.parseInt(s);
            happened[val] = true;
        }
        for (int i = 0; i < n + 1; i++) {
            if (happened[i] == false) {
                return i;
            }
        }
        return -1;
        
    }
    private void backtrack(int start, int n, Set<String> temp, List<List<String>> result, String str) {
        if (start == str.length() && temp.size() == n - 1) {
            result.add(new ArrayList<>(temp));
        }
        for (int i = start; i < str.length(); i++) {
            if (i > start + 1) {
                continue;
            }
            String subString = str.substring(start, i + 1);
            int val = Integer.parseInt(subString);
            
            // '01'
            if (val < 10 && subString.length() == 2) {
                continue;
            }
            if (val > n || val < 1) {
                continue;
            }
            if (temp.contains(subString)) {
                continue;
            }
            temp.add(subString);
            backtrack(i + 1, n, temp, result, str);
            temp.remove(subString);
        }
    }
}

// note:
// boolean[] visited could replace the temp and happend.