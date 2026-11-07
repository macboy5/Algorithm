import java.util.*;

class Solution {
    static int[][] map;
    static List<Integer> list = new ArrayList<>();
    public int[] solution(int rows, int columns, int[][] queries) {
        map = new int[rows][columns];
        
        // map 초기화
        int num = 1;
        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
                map[i][j] = num++;
            }
        }
        
        int[] answer = new int[queries.length];
        
        for(int i = 0; i < queries.length; i++){
            int[] query = queries[i];
            int x1 = query[0]-1;
            int y1 = query[1]-1;
            int x2 = query[2]-1;
            int y2 = query[3]-1;
                     
            // 회전
            answer[i] = rotate(x1, y1, x2, y2) ;
            
        }
        

        
        return answer;
    }
    
    
    private int rotate(int x1, int y1, int x2, int y2){
        
        int tmp = map[x1][y1];
        int min = tmp;
        
        // 좌변
        for(int i=x1; i< x2; i++){
            map[i][y1] = map[i+1][y1];
            min = Math.min(min, map[i][y1]);
        }
        
        // 하변
        for(int i=y1; i<y2; i++){
            map[x2][i] = map[x2][i+1];
            min = Math.min(min, map[x2][i]);
        }
        
        // 우변
        for (int i = x2; i > x1; i--) {
            map[i][y2] = map[i - 1][y2];
            min = Math.min(min, map[i][y2]);
        }
        
        // 상변
        for (int i = y2; i > y1 + 1; i--) {
            map[x1][i] = map[x1][i - 1];
            min = Math.min(min, map[x1][i]);
        }
        
        map[x1][y1+1] = tmp;  
        
        return min;
    }
    
    
}