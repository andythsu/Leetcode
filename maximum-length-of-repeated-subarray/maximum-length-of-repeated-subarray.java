/*
Use a dp to keep track of the answer up until i and j.
If A[i] and B[j] are the same, increment i and j by 1 because the question asks contiguous subarray
​
A: [1,2,3,2,1]
        i
B: [3,2,1,4,7]
    j
            
dp[4][2] = 1
dp[3][1] = dp[4][2] + 1 = 2
dp[2][0] = dp[3][1] + 1 = 3
​
*/
class Solution {
    public int findLength(int[] A, int[] B) {
        int answer = 0;
        int[][] dp = new int[A.length + 1][B.length + 1];
        for(int i=A.length-1; i>=0; i--){
            for(int j=B.length-1; j>=0; j--){
                if(A[i] == B[j]){
                    dp[i][j] = dp[i+1][j+1] + 1;
                    answer = Math.max(answer, dp[i][j]);
                }
            }
        }
        return answer;
    }
}
