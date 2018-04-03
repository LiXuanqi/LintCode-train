public class Solution {
    /**
     * @param colors: A list of integer
     * @param k: An integer
     * @return: nothing
     */
    public void sortColors2(int[] colors, int k) {
        if (colors == null || colors.length == 0) {
            return;
        }
        
        quickSort(colors, 0, colors.length - 1);
    }
    private void quickSort(int[] colors, int start, int end) {
        if (start >= end) {
            return;
        }
        
        int left = start;
        int right = end;
        int pivot = colors[(start + end) / 2];

        while (left <= right) {
            while (left <= right && colors[left] < pivot) {
                left++;
            }
            while (left <= right && colors[right] > pivot) {
                right--;
            }
            if (left <= right) {
                int temp = colors[left];
                colors[left] = colors[right];
                colors[right] = temp;
                left++;
                right--;
            }
        }
        
        quickSort(colors, start, right);
        quickSort(colors, left, end);
    }
}

// note: it could be solved by counting sort or rainbow sort.