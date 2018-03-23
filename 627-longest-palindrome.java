public class Solution {
    /**
     * @param s: a string which consists of lowercase or uppercase letters
     * @return: the length of the longest palindromes that can be built
     */
    public int longestPalindrome(String s) {
        // write your code here
        Set<Character> set = new HashSet<>();
        int result = 0;
        for (char c : s.toCharArray()){
            if(set.contains(c)){
                set.remove(c);
                result = result + 2;
            } else {
                set.add(c);
            }
        }
        if(set.size()==0){
            return result;
        } else {
            return result+1;
        }
    }
}