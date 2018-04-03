public class TwoSum {
    /*
     * @param number: An integer
     * @return: nothing
     */
    private List<Integer> nums = new ArrayList<>();
    
    public void add(int number) {
        nums.add(number);
    }

    /*
     * @param value: An integer
     * @return: Find if there exists any pair of numbers which sum is equal to the value.
     */
    public boolean find(int value) {
        int left = 0;
        int right = nums.size() - 1;
        
        Collections.sort(nums);
        
        while (left != right) {
            if (nums.get(left) == value - nums.get(right)) {
                return true;
            }
            if (nums.get(left) < value - nums.get(right)) {
                left++;
            } else {
                right--;
            }
        }
        return false;
    }
}

// note:
// List -- get(): to get the element by index.
// overflow.
// Collections.sort() -- sort the ArrayList.