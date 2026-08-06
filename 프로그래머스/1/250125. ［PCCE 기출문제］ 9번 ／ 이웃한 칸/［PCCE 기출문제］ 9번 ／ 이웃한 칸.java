class Solution {
    int[] dh = new int[]{1,-1,0,0};
    int[] dw = new int[]{0,0,1,-1};
    
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        
        int row = board.length;
        int col = board[0].length;
        
        String color = board[h][w];
        
        for(int dir = 0; dir<4; dir++){
            int nh = h + dh[dir];
            int nw = w + dw[dir];
            
            if(nh >=0 && nh < row && nw>=0 && nw<col){
                if(board[nh][nw].equals(color)) answer++;
            }
            
        }
        
        return answer;
    }
}