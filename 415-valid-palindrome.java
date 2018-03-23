public class Solution {
    /**
     * @param s: A string
     * @return: Whether the string is a valid palindrome
     */
    public boolean isPalindrome(String s) {
        // write your code here
        
        if (s == null) {
            return false;
        }
        // 可以不判断s.length() == 0
        
        int begin = 0;
        int end = s.length()-1;
        while(begin <= end){
            if(!isAlphanumeric(s.charAt(begin))){
                begin++;
                continue;
            }
            if(!isAlphanumeric(s.charAt(end))){
                end--;
                continue;
            }
            if(Character.toLowerCase(s.charAt(begin)) != Character.toLowerCase(s.charAt(end)) ){
                return false;
            }
            begin++;
            end--;
        }
        return true;
    }
    private boolean isAlphanumeric(char c){
        if(c==' '){
            return false;
        }
        int ascii = (int)c;
            /*0-9对应Ascii 48-57
            *A-Z 65-90
            *a-z 97-122
            */
        if((c>47&&c<58)||(c>64&&c<91)||(c>96&&c<123)){
            return true;
        } else {
            return false;
        }
    }
}