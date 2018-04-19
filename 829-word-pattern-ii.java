public class Solution {
    /**
     * @param pattern: a string,denote pattern string
     * @param str: a string, denote matching string
     * @return: a boolean
     */
    public boolean wordPatternMatch(String pattern, String str) {
        HashMap<Character, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        return dfs(pattern, str, map, set);

    }
    private boolean dfs(String pattern, String str, HashMap<Character, String> map, Set<String> set) {
        if (pattern.length() == 0 && str.length() == 0) {
            return true;
        }
        System.out.print(pattern);
        // case: "d" "ef" => "" "f"
        if (pattern.length() == 0) {
            return false;
        }
        if (map.containsKey(pattern.charAt(0))) {
            if (!str.startsWith(map.get(pattern.charAt(0)))) {
                return false;
            }
            int length = map.get(pattern.charAt(0)).length();
            return dfs(pattern.substring(1), str.substring(length), map, set);
        }
        for (int i = 0; i < str.length(); i++) {
            String prefix = str.substring(0, i + 1);
            if (set.contains(prefix)) {
                continue;
            }
            map.put(pattern.charAt(0), prefix);
            set.add(prefix);
            if (dfs(pattern.substring(1), str.substring(i + 1), map, set)) {
                return true;
            }
            map.remove(pattern.charAt(0));
            set.remove(prefix);
        }
        return false;
    }
}