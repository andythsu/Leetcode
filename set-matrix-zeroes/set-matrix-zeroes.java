class Solution {
    public void setZeroes(int[][] matrix) {
        boolean isFirstColZero = false;
        for(int r=0; r<matrix.length; r++){
            if(matrix[r][0] == 0){
                isFirstColZero = true;
            }
            for(int c=1; c<matrix[r].length; c++){
                if(matrix[r][c] == 0){
                    matrix[r][0] = 0;
                    matrix[0][c] = 0;
                }
            }
        }
        
        for(int r=1; r<matrix.length; r++){
            for(int c=1; c<matrix[r].length; c++){
                if(matrix[r][0] == 0 || matrix[0][c] == 0){
                    matrix[r][c] = 0;
                }
            }
        }
        
        // change first row to zero if necessary
        // if matrix[0][0] == 0, that means we need to set entire row to 0
        if(matrix[0][0] == 0){
            for(int c=0; c<matrix[0].length; c++){
                matrix[0][c] = 0;
            }
        }
        
        // change first col to zero if necessary
        if(isFirstColZero){
            for(int r=0; r<matrix.length; r++) {
                matrix[r][0] = 0;
            }
        }
    }
}