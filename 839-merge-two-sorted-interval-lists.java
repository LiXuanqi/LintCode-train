/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

public class Solution {
    /**
     * @param list1: one of the given list
     * @param list2: another list
     * @return: the new sorted list of interval
     */
    public List<Interval> mergeTwoInterval(List<Interval> list1, List<Interval> list2) {
        List<Interval> result = new ArrayList<>();
        if (list1 == null && list2 == null) {
            return result;
        }
        int i = 0;
        int j = 0;
        Interval last = null;
        Interval curt = null;
        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i).start <= list2.get(j).start) {
                curt = list1.get(i);
                i++;
            } else {
                curt = list2.get(j);
                j++;
            }
            last = merge(result, curt, last);
        }
        
        while (i < list1.size()) {
            curt = list1.get(i);
            last = merge(result, curt, last);
            i++;
        }
        while (j < list2.size()) {
            curt = list2.get(j);
            last = merge(result, curt, last);
            j++;
        }
        // [] [] => []
        if (last != null) {
            result.add(last);
        }
       
        return result;
    }
    private Interval merge(List<Interval> result, Interval curt, Interval last) {
        if (last == null) {
            return curt;
        }
        
        if (last.end < curt.start) {
            result.add(last);
            return curt;
        }
        
        last.end = Math.max(curt.end, last.end);
        return last;
    }
}