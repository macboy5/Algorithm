class Solution {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        
        int rLen = board.length;
        int cLen = board[0].length;

        int[][] diff = new int[rLen+1][cLen+1];
              
        
        for(int[] sk : skill){
            int type = sk[0];
            if(type == 1) type = -1; 
            if(type == 2) type = 1;
            int r1 = sk[1];
            int c1 = sk[2];
            int r2 = sk[3];
            int c2 = sk[4];
            int degree = sk[5];
            int value = type * degree;
            
            diff[r1][c1] += value;
            diff[r1][c2+1] -= value;
            diff[r2+1][c1] -= value;
            diff[r2+1][c2+1] += value;
            
        }
        
        for(int i=0; i<rLen; i++){
            for(int j=1; j<cLen; j++){
                diff[i][j] += diff[i][j-1];
            }
        }        
        
        for (int j = 0; j < cLen; j++) {
            for (int i = 1; i < rLen; i++) {
                diff[i][j] += diff[i - 1][j];
            }
        }
        
        for (int i = 0; i < rLen; i++) {
            for (int j = 0; j < cLen; j++) {
                if (board[i][j] + diff[i][j] > 0) {
                    answer++;
                }
            }
        }
        

        
        return answer;
    }
}