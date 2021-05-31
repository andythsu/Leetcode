class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = matrix.length - 1;
        int j = 0;
        while(i >= 0 && j < matrix[0].length){
            int mid = matrix[i][j];
            if(mid < target){
                j++;
            }else if (mid > target){
                i--;
            }else{
                return true;
            }
        }
        return false;
    }
}