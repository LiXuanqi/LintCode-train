public class Solution {
    /**
     * @param numbers: Give an array numbers of n integer
     * @return: Find all unique triplets in the array which gives the sum of zero.
     */
    public List<List<Integer>> threeSum(int[] numbers) {
        Arrays.sort(numbers);
        // why numbers.length - 2?
        // because: a <= b <= c
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < numbers.length - 2; i++) {
            if (i > 0 && numbers[i] == numbers[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = numbers.length - 1;
            twoSum(numbers, left, right, i, -numbers[i], result);
        }
        return result;
        
    }
    private void twoSum(int[] numbers, int left, int right, int a, int target, List<List<Integer>> result){
        while (left < right) {
            if (numbers[left] == target - numbers[right]) {
                List<Integer> temp = new ArrayList<>(); 
                temp.add(numbers[a]);
                temp.add(numbers[left]);
                temp.add(numbers[right]);
                result.add(temp);
                left++;
                right--;
                // note: can't ignore left < right, otherwise array index will out of bounds.
                while (left < right && numbers[left] == numbers[left - 1]) {
                    left++;
                }
                
                while (left < right && numbers[right] == numbers[right + 1]) {
                    right--;
                }

            } else if (numbers[left] < target - numbers[right]) {
                left++;
            } else {
                right--;
            }

        }
    }
}
// note :
// 1. How to skip the duplicated element?
// 2. How to skip the duplicated result?