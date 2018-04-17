public class Solution {
    /**
     * @param time: the given time
     * @return: the next closest time
     */
    private int minDiff = Integer.MAX_VALUE;
    private String result = "";
    public String nextClosestTime(String time) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < time.length(); i++) {
            if (time.charAt(i) == ':') {
                continue;
            }
            set.add(time.charAt(i) - '0');
        }
        
        if (set.size() == 1) {
            return time;
        }
        
        List<Integer> digits = new ArrayList<>(set);
        
        int minute = Integer.parseInt(time.substring(0,2)) * 60 + Integer.parseInt(time.substring(3,5));
        
        dfs("", 0, digits, minute);
        
        return result;
        
    }
    
    private void dfs(String current, int position, List<Integer> digits, int minute) {
        if (position == 4) {
            int currentMinutes = Integer.parseInt(current.substring(0,2)) * 60 + Integer.parseInt(current.substring(2,4));
            if (currentMinutes == minute) {
                return;
            }
            int diff = currentMinutes > minute ? currentMinutes - minute : 1440 - minute + currentMinutes;
            if (diff < minDiff) {
                minDiff = diff;
                result = current.substring(0,2) + ":" + current.substring(2,4);
            }
            return;
        }
        for (int i = 0; i < digits.size(); i++) {
            if (position == 0 && digits.get(i) > 2) {
                continue;
            }
            if (position == 1 && (current.charAt(0) - '0') * 10 + digits.get(i) > 24) {
                continue;
            }
            if (position == 2 && digits.get(i) > 5) {
                continue;
            }
            if (position == 3 && (current.charAt(2) - '0') * 10 + digits.get(i) > 59) {
                continue;
            }

            // not current = current + digits.get(i)
            // should deep copy?
            dfs(current + digits.get(i) , position + 1, digits, minute);
        }
    }
}