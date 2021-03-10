class Solution {
    public int singleNumber(int[] nums) {
        int ones = 0;
        int twos = 0;
        for(int num : nums){
            ones = (ones ^ num) & ~twos; // ~ is complement, ^ is XOR, & is AND
            twos = (twos ^ num) & ~ones;
        }
        return ones;
    }
}