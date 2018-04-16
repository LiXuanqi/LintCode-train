public class Solution {
    /*
     * @param s: A string
     * @param wordDict: A set of words.
     * @return: All possible sentences.
     */
    public List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> result = new ArrayList<>();
        
        dfs(0, new ArrayList<>(), s, wordDict, result);
        
        return result;
    }
    
    private void dfs(int start, List<String> temp, String s, Set<String> wordDict, List<String> result) {
        if (start == s.length()) {
            
            String words = new String();
            for (String word : temp) {
                if (words.length() == 0) {
                    words = words + word;
                } else {
                    words = words + ' ' + word;  
                }
            }
            
            result.add(words);
        }
        for (int i = start; i < s.length(); i++) {
            String subString = s.substring(start, i + 1);
            if (!wordDict.contains(subString)) {
                continue;
            }
            temp.add(subString);
            dfs(i + 1, temp, s, wordDict, result);
            temp.remove(temp.size() - 1);
        }
    }
}

// note: 
// just dfs will memory limit Exceeded.