import java.util.*;

class Solution {
    
    char[][] map;
    boolean[][] isTarget;
    
    public int solution(int m, int n, String[] board) {
        int blockCnt = 0;
        
        map = new char[m][n];
        isTarget = new boolean[m][n];
        
        for(int i=0; i<m; i++){
            map[i] = board[i].toCharArray();
        }
        
        // 2 x 2 블록에 같은 값이 채워져있으면 삭제 -> 재배열
        
        while(true){
            
            boolean isFound = false;
                        
            // isTarget 초기화
            for(int i=0; i<m; i++){
                Arrays.fill(isTarget[i], false);
            }
            
            
            for(int i=0; i<m-1; i++){
                for(int j=0; j<n-1; j++){

                    // 2 x 2 블록 스캔
                    char c = map[i][j];
                    if(c == 'd') continue;
                    
                    if(c == map[i+1][j] &&
                      c == map[i][j+1] &&
                      c == map[i+1][j+1]){

                        isTarget[i][j] = true;
                        isTarget[i][j+1] = true;
                        isTarget[i+1][j] =  true;
                        isTarget[i+1][j+1] = true;
                        isFound = true;
                    }
                }
            }
            
            // 더이상 삭제할 블록 없으면 break
            if(!isFound) break;
            
            // 블록 삭제
            for(int i=0; i<m; i++){
                for(int j=0; j<n; j++){
                    if(isTarget[i][j]){
                        map[i][j] = 'd';    //delete marker
                        blockCnt++;
                    }
                }
            }
            
            // 4. 재배열
            for (int j = 0; j < n; j++) {
                int writeIdx = m - 1; // 아래에서부터 채워 넣을 위치
                
                for (int i = m - 1; i >= 0; i--) {
                    if (map[i][j] != 'd') {
                        map[writeIdx][j] = map[i][j];
                        if (writeIdx != i) {
                            map[i][j] = 'd'; 
                        }
                        writeIdx--;
                    }
                }
            }
        }
        
                
        
        return blockCnt;
    }
}