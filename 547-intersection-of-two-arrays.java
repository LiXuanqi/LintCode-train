public class Solution {
    
    /*
     * @param nums1: an integer array
     * @param nums2: an integer array
     * @return: an integer array
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        // write your code here
        Set<Integer> resultSet = new HashSet<>();
        Set<Integer> set = new HashSet<>();
        for (int num : nums1) {
            set.add(num);
        }
        
        for (int num : nums2) {
            if (set.contains(num)) {
                resultSet.add(num);
            }
        }
        
        int size = resultSet.size();
        int[] result = new int[size];
        
        int index = 0;
        for (int num : resultSet) {
            result[index] = num;
            index++;
        }
      
        return result;
    }
};