import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        
        Stack<Integer> bucket = new Stack<>();
        
        for(int m : moves){
            
            int cur = get(m-1, board);
            if(cur == -1 ) continue;
            
            if(!bucket.isEmpty() && bucket.peek() == cur){
                bucket.pop();
                answer += 2;
            }
            else{
                bucket.push(cur);
            }
            
        }
        
        return answer;
    }
    
    // m번 열의 가장 낮은 행의 위치 값을 찾아서 return
    public int get(int col, int[][] board){

        
        for(int i=0; i<board.length; i++){
            int cur = board[i][col];
            if(cur != 0){
                board[i][col] = 0;
                return cur;
            }
        }
        
        
        return -1;
    }
    
    
}