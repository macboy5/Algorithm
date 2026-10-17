import java.util.*;

class Solution {
    
    int dr[] = {+1,-1,0,0};
    int dc[] = {0,0,+1,-1};
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        
        // 직사각형을 map에 표시
        int[][]map = new int[102][102];
        for(int[] r : rectangle){
            int leftX = r[0]*2;
            int leftY = r[1]*2;
            int rightX = r[2]*2;
            int rightY = r[3]*2;
            
            // 직사각형테두리 1 처리 내부 2
            for(int y=leftY; y<= rightY; y++){
                for(int x = leftX ; x<= rightX; x++){
                    if(map[y][x] == 2 ) continue;
                    
                    if(y == leftY || y== rightY || x == leftX || x == rightX){
                        map[y][x] = 1;
                    }
                    else{
                        map[y][x] = 2;
                    }
                }
            }
            
        }
        
        // 내부 0 으로 처리
        
         
        Queue< int[] > q = new ArrayDeque<>();
        boolean[][] isVisit = new boolean[102][102];
        
        q.add(new int[]{characterY*2, characterX*2, 0});
        isVisit[characterY*2][characterX*2] = true;
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int curY = cur[0];
            int curX = cur[1];
            int dis = cur[2];
            
            if(curX == itemX*2 && curY == itemY*2){
                answer = dis/2;
                break;
            }
            
            for(int dir=0; dir<4; dir++){
                int nr = curY + dr[dir];
                int nc = curX + dc[dir];
                
                if(nr >=0 && nr <= 100 
                  && nc>=0 && nc<= 100
                  && !isVisit[nr][nc]
                  && map[nr][nc] == 1){
                    
                    isVisit[nr][nc] = true;
                    q.add(new int[]{nr, nc, dis+1});
                    
                }
                
            }
            
            
        }
        
        
        return answer;
    }
}