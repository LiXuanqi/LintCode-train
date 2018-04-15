public class Solution {
    /*
     * @param : a string to be split
     * @return: all possible split string array
     */
    public List<List<String>> splitString(String s) {
        List<List<String>> result = new ArrayList<>();
        
        if (s == null) {
            return result;
        }
        
        if (s.length() == 0) {
            result.add(new ArrayList<String>());
            return result;
        }
        
        backtrack(0, new ArrayList<>(), result, s);
        
        return result;
    }
    
    private void backtrack(int start, List<String> temp, List<List<String>> result, String s) {
        if (start == s.length()) {
            result.add(new ArrayList<>(temp));
        }
        for (int i = start; i < s.length(); i++) {
            if (i > start + 1) {
                continue;
            }
            String subString = s.substring(start, i + 1);
            temp.add(subString);
            backtrack(i + 1, temp, result, s);
            temp.remove(temp.size() - 1);
        }
    }
}