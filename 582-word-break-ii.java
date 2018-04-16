public class Solution {
    /*
     * @param s: A string
     * @param wordDict: A set of words.
     * @return: All possible sentences.
     */
    public List<String> wordBreak(String s, Set<String> wordDict) {
        HashMap<String, List<String>> memo = new HashMap<>();
      
        return wordBreakHelper(s, wordDict, memo);
    }
    
    private List<String> wordBreakHelper(String s, 
                                        Set<String> wordDict, 
                                        HashMap<String, List<String>> memo) {
        if (memo.containsKey(s)) {
            return memo.get(s);
        }
        // note: if result is as a parameter of function, it will have a error.
        List<String> result = new ArrayList<>();
        
        if (s.length() == 0) {
            return result;
        }
        if (wordDict.contains(s)) {
            result.add(s);
        }
        for (int i = 0; i < s.length(); i++) {
            String subString = s.substring(0, i + 1);
            if (!wordDict.contains(subString)) {
                continue;
            }
            
            String suffix = s.substring(i + 1);
            List<String> segmentations = wordBreakHelper(suffix, wordDict, memo);
            
            for (String segmentation : segmentations) {
                result.add(subString + ' ' + segmentation);
            }
        }
        
        memo.put(s, result);
        return result;
    }
}

// note:
// just dfs will memory limit Exceeded.
// 