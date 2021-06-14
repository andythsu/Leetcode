class Solution {
    public void rotate(int[][] matrix) {
        // rotate diagonally
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[i].length; j++){
                if(i < j){
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }
        // switch left to right
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[i].length/2; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix[i].length - 1 - j];
                matrix[i][matrix[i].length - 1 - j] = temp;
            }
        }
    }
}