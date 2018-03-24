public class Solution {
    /**
     * @param s: input string
     * @return: the longest palindromic substring
     */
    public String longestPalindrome(String s) {
        // write your code here
        if (s == null || s.length() == 0) {
            return "";
        }
        int len = 0;
        int start = 0;
        int longest = 0;
        for (int i = 0; i < s.length(); i++) {
            len = findLongestPalindrome(s, i, i);
            // abac i=1 len=3
            // babac i=2 len=3
            if (len > longest) {
                longest = len;
                start = i - (len - 1) / 2;
            }
            
            len = findLongestPalindrome(s, i, i+1);
            // abbac i=1 len=4
            if (len > longest) {
                longest = len;
                start = i + 1 - len/2;
            }
            
        }
        return s.substring(start, start + longest);
    }
    private int findLongestPalindrome(String s, int left, int right){
        int len = 0;
        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) != s.charAt(right)) {
                break;
            }
            len = len + (left == right ? 1 : 2);
            left--;
            right++;
        }
        return len;
    }
}