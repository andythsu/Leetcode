class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        return secondSol(matrix, target);
    }
    
    public boolean secondSol(int[][] matrix, int target){
        int i = matrix.length - 1;
        int j = 0;
        while(i >= 0 && j <= matrix[i].length - 1){
            int mid = matrix[i][j];
            if(mid == target){
                return true;
            }else if (mid < target){
                j++;
            }else{
                i--;
            }
        }
        return false;
    }
    
    public boolean firstSol(int[][] matrix, int target){
        int left = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int right = m * n - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            int midVal = matrix[mid / n][mid % n];
            if(midVal == target){
                return true;
            }else if (midVal < target){
                left = mid + 1; 
            }else{
                right = mid - 1;
            }
        }
        
        return false;
        
    }
}