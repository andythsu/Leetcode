class Solution {
    public int countNegatives(int[][] grid) {
        int row = grid.length - 1;
        int col = 0;
        int colLen = grid[0].length;
        int total = 0;
        while(row >= 0 && col < colLen){
            int current = grid[row][col];
            if(current < 0){
                total += colLen - col;
                row--;
            }else{
                col++;
            }
        }
        return total;
    }
}