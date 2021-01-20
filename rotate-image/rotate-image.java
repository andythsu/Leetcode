/*
transpose 
1 2 3
4 5 6
7 8 9
​
1 4 7
2 5 8
3 6 9
swap head and tail
7 4 1
8 5 2
9 6 3
*/
class Solution {
    public void rotate(int[][] matrix) {
        matrix = swap(transpose(matrix));
    }
    public int[][] transpose(int[][] matrix){
        for(int r=0; r<matrix.length; r++){
            for(int c=r; c<matrix[r].length; c++){
                int temp = matrix[r][c];
                matrix[r][c] = matrix[c][r];
                matrix[c][r] = temp;
            }
        }
        return matrix;
    }
    public int[][] swap(int[][] matrix){
        for(int r=0; r<matrix.length; r++){
            for(int c=0; c<matrix[r].length / 2; c++){
                int temp = matrix[r][c];
                matrix[r][c] = matrix[r][matrix[r].length - 1 - c];
                matrix[r][matrix[r].length - 1 - c] = temp;
            }
        }
        return matrix;
    }
}
