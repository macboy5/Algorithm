import java.util.*;

class Solution {
    
    static int[] dx = new int[]{1,-1,0,0};;
    static int[] dy = new int[]{0,0,1,-1};;
    static int rowLen;
    static int colLen;
    static char[][]map;
    
    public int solution(String[] board) {
        int answer = -1;
        
        
        rowLen = board.length;
        colLen = board[0].length();
        
        map = new char[rowLen][colLen];
        
        for(int i=0; i<rowLen; i++){
            map[i] = board[i].toCharArray();
        }
        
        for(int i=0; i<rowLen; i++){
            for(int j=0; j<colLen; j++){
                if(map[i][j] == 'R'){
                    return findPath(i,j);
                } 
            }
        }
        
        
        
        return answer;
    }
    
    int findPath(int r, int c){
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r,c,0});
        boolean[][] visited = new boolean[rowLen][colLen];
        visited[r][c] = true;
        
        while(!q.isEmpty()){
            
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int cnt = cur[2];
            
            if(map[x][y] == 'G'){
                return cnt;
            }
            
            for(int i=0; i<4; i++){
                int nx = x;
                int ny = y;
                
                while(nx>=0 && nx<rowLen && ny>=0 && ny<colLen
                     && map[nx][ny] != 'D'){
                    nx += dx[i];
                    ny += dy[i];
                }
                
                nx -= dx[i];
                ny -= dy[i];
                
                if(!visited[nx][ny]){
                    q.add(new int[]{nx,ny,cnt+1});
                    visited[nx][ny] = true;
                }

                
                
            }
            
        }
        
        
        
        return -1;
    }
}