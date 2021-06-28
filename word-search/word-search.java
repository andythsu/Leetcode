class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length; j++){
                if(helper(i,j,board,word,0)) return true;
            }
        }
        return false;
    }
    
    public boolean helper(int i, int j, char[][] board, String word, int count){
        if(i < 0 || i >= board.length || j < 0 || j >= board[i].length) return false;
        
        if(board[i][j] != word.charAt(count) || board[i][j] == '#') return false;
        
        if(board[i][j] == word.charAt(count)){
            count++;
        }
        
        if(count == word.length()) return true;
        
        char temp = board[i][j];
    
        board[i][j] = '#';
        
        boolean top = helper(i-1, j, board, word, count);
        boolean down = helper(i+1, j, board, word, count);
        boolean left = helper(i, j-1, board, word, count);
        boolean right = helper(i, j+1, board, word, count);
        
        board[i][j] = temp;
        
        return top || down || left || right;
        
    }
}