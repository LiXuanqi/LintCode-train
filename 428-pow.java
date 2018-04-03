public class Solution {
    /*
     * @param x: the base number
     * @param n: the power number
     * @return: the result
     */
    public double myPow(double x, int n) {
        if (n >= 0) {
            return Pow(x, n);
        } else {
            return 1 / Pow(x, Math.abs((long)n));
        }
    }
    private double Pow(double x, long n) {
        double num = x;
        if (n == 1) {
            return x;
        }
        if (n == 0) {
            return 1;
        }
        if (n % 2 == 0) {
            return Pow(x * x, n/2);
        } else {
            return num * Pow(x, n - 1);
        }
    }
}