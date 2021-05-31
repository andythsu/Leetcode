class Solution {
    public boolean isPowerOfTwo(int n) {
        // n: 0010
        // n-1: 0001
        // n - 1 will convert all 1's to 0's and 0's to 1's except for 0
        if(n == 0 || n == Integer.MIN_VALUE) return false;
        return (n & (n-1)) == 0;
    }
}