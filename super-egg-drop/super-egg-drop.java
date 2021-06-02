class Solution {
    public int superEggDrop(int eggs, int floors) {
        // https://leetcode.com/problems/super-egg-drop/discuss/158974/C%2B%2BJavaPython-2D-and-1D-DP-O(KlogN)
        int[][] dp = new int[floors + 1][eggs + 1];
        int moves = 0;
        while (dp[moves][eggs] < floors) {
            moves++;
            for (int e = 1; e <= eggs; e++)
                dp[moves][e] = dp[moves - 1][e - 1] + dp[moves - 1][e] + 1;
        }
        return moves;
    }
}