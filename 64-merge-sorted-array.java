public class Solution {
    /*
     * @param A: sorted integer array A which has m elements, but size of A is m+n
     * @param m: An integer
     * @param B: sorted integer array B which has n elements
     * @param n: An integer
     * @return: nothing
     */
    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        // write your code here
        int total = m + n;
        for (int i = total - 1; i >= 0; ) {
            
            if (m == 0 && n != 0) {
                A[i] = B[n - 1];
                n--;
                i--;
            }
            
            if (n ==0 && m != 0) {
                System.out.print(i);
                System.out.print(m);
                A[i] = A[m - 1];
                m--;
                i--;
            }
            
            while (m != 0 && n != 0) {
                if (A[m - 1] < B[n - 1]) {
                    A[i] = B[n - 1];
                    n--;
                    i--;
                } else {
                    A[i] = A[m - 1];
                    m--;
                    i--;
                }
            }
            
        }

    }
}