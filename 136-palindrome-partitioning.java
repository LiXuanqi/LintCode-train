public class Solution {
    /*
     * @param s: A string
     * @return: A list of lists of string
     */
    public List<List<String>> partition(String s) {
        // write your code here
        List<List<String>> result = new ArrayList<>();
        
        if (s == null || s.length() == 0) {
            return result;
        }
        backtrack(0, new ArrayList<>(), s, result);
        return result;
    }
    private void backtrack(int start, List<String> temp, String s, List<List<String>> result) {
        if (start == s.length()) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            String subString = s.substring(start, i + 1);
            if (!isPalindrome(subString)) {
                continue;
            }
            
            temp.add(subString);
            backtrack(i + 1, temp, s, result);
            temp.remove(temp.size() - 1);
        }
    }
    private boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        System.out.print(s + ' ');
        int start = 0;
        int end = s.length() - 1;
        while (start <= end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}