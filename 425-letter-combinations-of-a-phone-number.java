public class Solution {
    /**
     * @param digits: A digital string
     * @return: all posible letter combinations
     */
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;   
        }
        
        HashMap<Character, char[]> map = new HashMap<>();
        map.put('1', new char[] {});
        map.put('2', new char[] {'a', 'b', 'c'});
        map.put('3', new char[] {'d', 'e', 'f'});
        map.put('4', new char[] {'g', 'h', 'i'});
        map.put('5', new char[] {'j', 'k', 'l'});
        map.put('6', new char[] {'m', 'n', 'o'});
        map.put('7', new char[] {'p', 'q', 'r', 's'});
        map.put('8', new char[] {'t', 'u', 'v'});
        map.put('9', new char[] {'w', 'x', 'y', 'z'});
        map.put('0', new char[] {});

        dfs(digits, new StringBuilder(), map, result, 0);
        return result;
        
    }
    private void dfs(String digits, StringBuilder temp, HashMap<Character, char[]> map, List<String> result, int pos) {

        if (pos == digits.length()) {
            result.add(temp.toString());
            // note: don't ignore return;
            return;
        }
        char digit = digits.charAt(pos);
        for (char character : map.get(digit)) {
            temp.append(character);
            dfs(digits, temp, map, result, pos + 1);
            temp.deleteCharAt(temp.length() - 1);
        }
    }
}