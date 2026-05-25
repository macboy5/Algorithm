class Solution {
    public int solution(int[][] board) {
        int answer = 0;
        
        int row = board.length;
        int col = board[0].length;
        
        for(int i=0; i<row ; i++){
            for(int j=0; j<col ; j++){
                int cur = board[i][j];
                if(cur == 1){
                    if(i-1>=0 && j-1>=0){
                        if(board[i-1][j-1] == 0) board[i-1][j-1] = -1;
                    }
                    if(i-1>=0){
                        if(board[i-1][j] == 0) board[i-1][j] = -1;
                    }
                    if(i-1>=0 && j+1 < col ){
                        if(board[i-1][j+1] == 0) board[i-1][j+1] = -1;
                    }
                    if(j-1>=0){
                        if(board[i][j-1] == 0) board[i][j-1] = -1;
                    }
                    if(j+1<col){
                        if(board[i][j+1] == 0) board[i][j+1] = -1;
                    }
                    if(i+1<row && j-1>=0 ){
                        if(board[i+1][j-1] == 0) board[i+1][j-1] = -1;
                    }
                    if(i+1<row){
                        if(board[i+1][j] == 0) board[i+1][j] = -1;
                    }
                    if(i+1<row && j+1 < col){
                        if(board[i+1][j+1] == 0) board[i+1][j+1] = -1;
                    }
                    
                }
                else continue;
            }
        }
        
        
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(board[i][j] == 0) answer++;
            }
        }
        
        
        
        return answer;
    }
}