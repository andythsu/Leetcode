class Solution {
public double myPow(double x, int n) {
    if (n == 0) return 1;
    if (n == 1) return x;
    if (n == -1) return 1 / x;

    final int mid = n / 2;

    if (mid * 2 == n) {
        // n is even.
        double powXMID = myPow(x, mid);
        return powXMID * powXMID;
    } else {
        // n is odd.
        double powXMID = myPow(x, mid);
        return powXMID * powXMID * myPow(x, n - mid * 2);
    }
}
}