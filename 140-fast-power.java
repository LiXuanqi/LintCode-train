public class Solution {
    /**
     * @param a: A 32bit integer
     * @param b: A 32bit integer
     * @param n: A 32bit integer
     * @return: An integer
     */
    public int fastPower(int a, int b, int n) {
        if (n == 0) {
            return 1 % b;
        }
        if (n == 1) {
            return a % b;
        }
        if (n % 2 == 0) {
            long temp = fastPower(a, b, n / 2) % b;
            long result = temp * temp;
            return (int) (result % b);
        } else {
            long temp = fastPower(a, b, n / 2) % b;
            long result = (temp * temp) % b * a;
            return (int) (result % b);
        }
    }
}

// note: overflow. int * int.