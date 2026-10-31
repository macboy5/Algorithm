import java.util.*;

class Solution {
    public int[][] solution(int[][] arr) {
        int[][] answer = {};
        
        int row = arr.length;
        int col = arr[0].length;
        int len = Math.max(row, col);
        
        answer = new int[len][len];
        for(int i=0; i<len ; i++) {
            Arrays.fill(answer[i], 0);
        }
        
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                
                answer[i][j] = arr[i][j];
                
                
                
            }
        }
        

        
        return answer;
    }
}